package io.kimmking.rpcfx.netty4;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.util.CharsetUtil;

import java.util.concurrent.CountDownLatch;

public class MyClientInboundHandler extends SimpleChannelInboundHandler<FullHttpResponse> {

    private CountDownLatch countDownLatch;
    private RpcfxResponse rpcfxResponse;


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpResponse fullHttpResponse)  {
        ByteBuf buf = fullHttpResponse.content();
        String result = buf.toString(CharsetUtil.UTF_8);
        RpcfxResponse rpcfxResponse = JSON.parseObject(result, RpcfxResponse.class);
        this.rpcfxResponse = rpcfxResponse;
        countDownLatch.countDown();
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public RpcfxResponse getRpcfxResponse() throws InterruptedException {
        countDownLatch.await();
        return rpcfxResponse;
    }




    //    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//
////        RpcfxRequest request2 = new RpcfxRequest();
////        request2.setServiceClass("io.kimmking.rpcfx.demo.api.UserService");
////        request2.setMethod("findById");
////        request2.setParams(new Object[]{1});
////
////        URI uri = new URI("/");
////        FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_0,
////                HttpMethod.POST, uri.toASCIIString(),Unpooled.wrappedBuffer(JSON.toJSONString(request2).getBytes(StandardCharsets.UTF_8)));
//
////        request.headers().add(HttpHeaderNames.CONNECTION,HttpHeaderValues.KEEP_ALIVE);
////        request.headers().add(HttpHeaderNames.CONTENT_TYPE,HttpHeaderValues.APPLICATION_JSON);
////        request.headers().add(HttpHeaderNames.ACCEPT_ENCODING,HttpHeaderValues.GZIP);
////        request.headers().add(HttpHeaderNames.CONTENT_LENGTH,request.content().readableBytes());
//        //ctx.writeAndFlush(request);
//    }


//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("msg -> "+msg);
//        FullHttpResponse response = (FullHttpResponse)msg;
//        ByteBuf buf = response.content();
//        String result = buf.toString(CharsetUtil.UTF_8);
//        System.out.println("response -> "+result);
//    }

}