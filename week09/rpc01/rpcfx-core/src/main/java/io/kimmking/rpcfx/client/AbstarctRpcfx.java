package io.kimmking.rpcfx.client;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.kimmking.rpcfx.netty4.NettyHttpClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class AbstarctRpcfx {

    public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

    protected static RpcfxResponse post(RpcfxRequest req, String url) throws IOException {
        String reqJson = JSON.toJSONString(req);
        System.out.println("req json: "+reqJson);

        // 1.可以复用client
        // 2.尝试使用httpclient或者netty client
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSONTYPE, reqJson))
                .build();
        String respJson = client.newCall(request).execute().body().string();
        System.out.println("resp json: "+respJson);
        return JSON.parseObject(respJson, RpcfxResponse.class);
    }


    protected static RpcfxResponse nettyPost(RpcfxRequest req, String host,int port) throws Exception {
        final RpcfxResponse[] rpcfxResponse = new RpcfxResponse[1];
        try {
            NettyHttpClient.execute(host, port, new SimpleChannelInboundHandler<FullHttpResponse>() {
                @Override
                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                    System.out.println("netty req json: "+JSON.toJSONString(req));

                    URI uri = new URI("/");
                    FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_0,
                            HttpMethod.POST, uri.toASCIIString(), Unpooled.wrappedBuffer(JSON.toJSONString(req).getBytes(StandardCharsets.UTF_8)));
                    request.headers().add(HttpHeaderNames.CONNECTION,HttpHeaderValues.KEEP_ALIVE);
                    request.headers().add(HttpHeaderNames.CONTENT_TYPE,HttpHeaderValues.APPLICATION_JSON);
                    request.headers().add(HttpHeaderNames.ACCEPT_ENCODING,HttpHeaderValues.GZIP);
                    request.headers().add(HttpHeaderNames.CONTENT_LENGTH,request.content().readableBytes());
                    ctx.writeAndFlush(request);
                }
                @Override
                protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpResponse fullHttpResponse) throws Exception {
                    ByteBuf buf = fullHttpResponse.content();
                    String result = buf.toString(CharsetUtil.UTF_8);
                    System.out.println("netty resp json: "+result);
                    rpcfxResponse[0] = JSON.parseObject(result, RpcfxResponse.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rpcfxResponse[0];
    }



}
