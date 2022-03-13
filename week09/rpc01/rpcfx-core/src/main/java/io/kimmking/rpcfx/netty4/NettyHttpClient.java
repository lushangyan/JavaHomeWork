package io.kimmking.rpcfx.netty4;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class NettyHttpClient {


    public static void execute(String host, int port, SimpleChannelInboundHandler<FullHttpResponse> handle){
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new HttpClientCodec());
                    //聚合
                    ch.pipeline().addLast(new HttpObjectAggregator(1024 * 10 * 1024));
                    //解压
                    //ch.pipeline().addLast(new HttpContentDecompressor());
                    ch.pipeline().addLast(handle);
                }
            });
            // Start the client.
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8080).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        NettyHttpClient.execute("localhost", 8080, new SimpleChannelInboundHandler<FullHttpResponse>() {

            @Override
            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                RpcfxRequest request2 = new RpcfxRequest();
                request2.setServiceClass("io.kimmking.rpcfx.demo.api.UserService");
                request2.setMethod("findById");
                request2.setParams(new Object[]{1});

                URI uri = new URI("/");
                FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_0,
                        HttpMethod.POST, uri.toASCIIString(), Unpooled.wrappedBuffer(JSON.toJSONString(request2).getBytes(StandardCharsets.UTF_8)));

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
                System.out.println("response -> "+result);
            }
        });
    }

}