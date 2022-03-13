package io.kimmking.rpcfx.client;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import io.kimmking.rpcfx.api.*;
import io.kimmking.rpcfx.exception.RpcfxException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.matcher.ElementMatchers;
import okhttp3.*;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static io.kimmking.rpcfx.client.AbstarctRpcfx.nettyPost;
import static io.kimmking.rpcfx.client.AbstarctRpcfx.post;

public final class RpcfxByteBuddy {

    static {
        ParserConfig.getGlobalInstance().addAccept("io.kimmking");
    }



    public static <T> T create(final Class<T> serviceClass, final String url, Filter... filters) throws Exception {

        // 0. 替换动态代理 -> 字节码生成
        return (T) new ByteBuddy()
                .subclass(Object.class)
                .implement(serviceClass)
                .method(ElementMatchers.isDeclaredBy(serviceClass))
                .intercept(MethodDelegation.to(new AccessServerInterceptor(serviceClass, url,filters)))
                .make()
                .load(serviceClass.getClassLoader())
                .getLoaded()
                .newInstance();
    }

    public static class AccessServerInterceptor {

        public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

        private final Class<?> serviceClass;
        private final String url;
        private final Filter[] filters;

        public <T> AccessServerInterceptor(Class<T> serviceClass, String url, Filter... filters) {
            this.serviceClass = serviceClass;
            this.url = url;
            this.filters = filters;
        }


        @RuntimeType
        public Object intercept(@Origin Method method, @AllArguments Object[] args) throws Throwable {

            // 加filter地方之二
            // mock == true, new Student("hubao");

            RpcfxRequest request = new RpcfxRequest();
            request.setServiceClass(this.serviceClass.getName());
            request.setMethod(method.getName());
            request.setParams(args);

            if (null!=filters) {
                for (Filter filter : filters) {
                    if (!filter.filter(request)) {
                        return null;
                    }
                }
            }

            //Netty+HTTP 作为 client 端传输方式
            //RpcfxResponse response = nettyPost(request,"localhost",8080);
            RpcfxResponse response = post(request, url);


            // 加filter地方之三
            // Student.setTeacher("cuijing");

            // 这里判断response.status，处理异常
            // 考虑封装一个全局的RpcfxException
            if(response.isStatus() == false){
                response.setException(new RpcfxException(response.getException()));
                throw new RpcfxException(JSON.toJSONString(response));
            }


            return JSON.parse(response.getResult().toString());

        }


    }


}
