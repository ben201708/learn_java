package com.netty.server;


import com.netty.handler.ClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


import java.util.Scanner;

/**
 * @User: benhuang
 * @Date: 2017/9/17
 * @Time: 23:20
 */
public class Client implements Runnable {
    static ClientHandler client = new ClientHandler();

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Client());
        thread.start();
        Scanner scanner = new Scanner( System.in );
        while (client.sendMsg( scanner.nextLine() )) ;
        System.out.println("sendMsg");
    }

    @Override
    public void run() {
        String host = "127.0.0.1";
        int port = 9090;
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group( workerGroup );
            b.channel( NioSocketChannel.class );
            b.option( ChannelOption.SO_KEEPALIVE, true );
            b.handler( new ChannelInitializer<SocketChannel>() {
                //初始化channel
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast( client );
                }
            } );
            ChannelFuture f = b.connect( host, port ).sync();// 配置完成，开始绑定server，通过调用sync同步方法阻塞直到绑定成功
            f.channel().closeFuture().sync();// 应用程序会一直等待，直到channel关闭
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
