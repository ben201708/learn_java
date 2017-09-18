package com.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;


/**
 * @User: benhuang
 * @Date: 2017/9/17
 * @Time: 23:15
 */
public class Server {

    public void run(int port) throws Exception {
        EventLoopGroup manageGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();// 通过nio方式来接收连接和处理连接
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group( manageGroup, workerGroup )
                    .channel( NioServerSocketChannel.class )// 设置nio类型的channel
                    .option( ChannelOption.SO_BACKLOG, 1024 )
                    .localAddress( new InetSocketAddress( port ) )// 设置监听端口
                    .childOption( ChannelOption.SO_KEEPALIVE, true )
                    .childHandler( new ChannelInitializer<SocketChannel>() {
                        //有连接到达时会创建一个channel
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            // pipeline管理channel中的Handler，在channel队列中添加一个handler来处理业务
                            ch.pipeline().addLast( new ServerHandler() );
                        }
                    } );
            ChannelFuture f = b.bind().sync();// 配置完成，开始绑定server，通过调用sync同步方法阻塞直到绑定成功
            System.out.println( "服务器开启：" + port );
            f.channel().closeFuture().sync();// 应用程序会一直等待，直到channel关闭
        } finally {
            //关闭EventLoopGroup，释放掉所有资源包括创建的线程
            workerGroup.shutdownGracefully();
            manageGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new Server().run( 9090 );
    }
}
