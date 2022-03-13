package io.kimmking.rpcfx.netty4;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;
import java.nio.charset.StandardCharsets;

public class NettyHttpClientInboundHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        RpcfxRequest request2 = new RpcfxRequest();
        request2.setServiceClass("io.kimmking.rpcfx.demo.api.UserService");
        request2.setMethod("findById");
        request2.setParams(new Object[]{1});

        URI uri = new URI("/");
        FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_0,
                HttpMethod.POST, uri.toASCIIString(),Unpooled.wrappedBuffer(JSON.toJSONString(request2).getBytes(StandardCharsets.UTF_8)));

        request.headers().add(HttpHeaderNames.CONNECTION,HttpHeaderValues.KEEP_ALIVE);
        request.headers().add(HttpHeaderNames.CONTENT_TYPE,HttpHeaderValues.APPLICATION_JSON);
        request.headers().add(HttpHeaderNames.ACCEPT_ENCODING,HttpHeaderValues.GZIP);
        request.headers().add(HttpHeaderNames.CONTENT_LENGTH,request.content().readableBytes());
        ctx.writeAndFlush(request);

    }




    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("msg -> "+msg);
        FullHttpResponse response = (FullHttpResponse)msg;
        ByteBuf buf = response.content();
        String result = buf.toString(CharsetUtil.UTF_8);
        System.out.println("response -> "+result);
    }
}