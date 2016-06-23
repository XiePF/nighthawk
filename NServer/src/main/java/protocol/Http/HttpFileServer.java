package protocol.Http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created by xpf on 2016/06/23.
 */
public class HttpFileServer {

    private static final String DEFAULT_URL = "com";

    public void bind(final int port, final String url) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast("http-decoder", new HttpRequestDecoder());
                            socketChannel.pipeline()
                                    .addLast("http-aggregator", new HttpObjectAggregator(65536));
                            socketChannel.pipeline()
                                    .addLast("http-encoder", new HttpResponseEncoder());
                            socketChannel.pipeline()
                                    .addLast("http-chunked", new ChunkedWriteHandler());
                            socketChannel.pipeline()
                                    .addLast("fileServerHandler", new HttpFileServerHandler(url));
                        }
                    });
            ChannelFuture f = b.bind("172.16.12.20", port).sync();
            System.out.println("Http 文件目录服务器已启动，网址是：" + "http://172.16.12.20:" + port + url);
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }
        String url = DEFAULT_URL;
        new HttpFileServer().bind(port, url);
    }
}
