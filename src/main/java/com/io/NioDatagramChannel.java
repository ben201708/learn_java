package com.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @User: benhuang
 * @Date: 2017/9/11
 * @Time: 20:57
 */
public class NioDatagramChannel {

    public static void main(String[] args) {
        new NioDatagramChannel().datagramChannelRead();
    }


    private void datagramChannelRead() {
        DatagramChannel channel = null;
        try {
            channel = DatagramChannel.open();
            channel.socket().bind(new InetSocketAddress(8888));

            ByteBuffer buffer = ByteBuffer.allocate(48);

            buffer.clear();

            //receive()方法会将接收到的数据包内容复制到指定的Buffer. 如果Buffer容不下收到的数据，多出的数据将被丢弃。
            channel.receive(buffer);

            int byteRead = channel.read(buffer);

            buffer.flip();

            while (byteRead != -1) {
                while (buffer.hasRemaining()) {
                    System.out.printf("read:%s%n", buffer.get());
                }

                buffer.clear();
                byteRead = channel.read(buffer);
            }


            channel.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
