package com.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @User: benhuang
 * @Date: 2017/9/11
 * @Time: 21:30
 */
public class NioSocketChannel {

    public static void main(String[] args) {
        //new NioSocketChannel().socketChannelRead();
        new NioSocketChannel().socketChannelReq();
    }

    private void socketChannelRead() {

        SocketChannel channel = null;
        try {
            channel = SocketChannel.open();
            channel.connect(new InetSocketAddress("www.baidu.com", 80));

            ByteBuffer buffer = ByteBuffer.allocate(2048);

            int byteRead = channel.read(buffer);

            buffer.flip();

            while (byteRead != -1) {
                while (buffer.hasRemaining()) {
                    System.out.println("read:" + (char) buffer.get());
                }
                buffer.clear();
                byteRead = channel.read(buffer);
            }


            channel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void socketChannelReq() {

        String newData = "GET http://localhost/ HTTP/1.1\n" +
                "Host: localhost\n" +
                "Proxy-Connection: keep-alive\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Encoding: gzip, deflate, sdch, br\n" +
                "Accept-Language: zh-CN,zh;q=0.8,en;q=0.6,ko;q=0.4,zh-TW;q=0.2\n";

        SocketChannel channel = null;
        try {
            channel = SocketChannel.open();
            channel.connect(new InetSocketAddress("127.0.0.1", 80));

            //判断链接上了才进行
            while (!channel.finishConnect()) {
            }

            ByteBuffer bufferWrite = ByteBuffer.wrap(newData.getBytes());

            while (bufferWrite.hasRemaining()) {
                channel.write(bufferWrite);
            }

            ByteBuffer bufferRead = ByteBuffer.allocate(2048);
            int c = channel.read(bufferRead);


            while (c != -1) {
                bufferRead.flip();
                while (bufferRead.hasRemaining()) {
                    System.out.print((char) bufferRead.get());
                }

                bufferRead.clear();
                c = channel.read(bufferRead);
            }


            channel.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
