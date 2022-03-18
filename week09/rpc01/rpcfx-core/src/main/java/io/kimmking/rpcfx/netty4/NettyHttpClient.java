package io.kimmking.rpcfx.netty4;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;

public class NettyHttpClient {


    public static RpcfxResponse sendRequest(RpcfxRequest req,String url, MyClientInboundHandler handle){
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            URI uri = new URI(url);
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.AUTO_CLOSE,true)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.AUTO_CLOSE, true)
                    .option(ChannelOption.SO_KEEPALIVE, true);

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
            ChannelFuture channelFuture = bootstrap.connect(uri.getHost(), uri.getPort()).sync();
            //ByteBuf byteBuf = Unpooled.wrappedBuffer(JSON.toJSONString(req).getBytes(StandardCharsets.UTF_8));

            FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_0,
                    HttpMethod.POST,
                    uri.toASCIIString(),
                    Unpooled.wrappedBuffer(JSON.toJSONString(req).getBytes(StandardCharsets.UTF_8)));
            request.headers().add(HttpHeaderNames.CONNECTION,HttpHeaderValues.KEEP_ALIVE);
            request.headers().add(HttpHeaderNames.CONTENT_TYPE,HttpHeaderValues.APPLICATION_JSON);
            request.headers().add(HttpHeaderNames.ACCEPT_ENCODING,HttpHeaderValues.GZIP);
            request.headers().add(HttpHeaderNames.CONTENT_LENGTH,request.content().readableBytes());
            Channel channel = channelFuture.channel();
            channel.writeAndFlush(request).sync();
            //channelFuture.channel().closeFuture().sync();

            System.out.println("nettyreq json: " + JSON.toJSONString(req));
            RpcfxResponse rpcfxResponse = handle.getRpcfxResponse();
            System.out.println("netty resp json: " + JSON.toJSONString(req));
            return rpcfxResponse;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }


        return null;
    }



}