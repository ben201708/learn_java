package com.io;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @User: benhuang
 * @Date: 2017/9/9
 * @Time: 12:38
 */
public class NIOStream {

    private static final String fileReadPath = "E:/server_java/learn_java/src/com/io/111.txt";
    private static final String fileWritePath = "E:/server_java/learn_java/src/com/io/666.txt";

    private static final String mode = "rw";

    public static void main(String[] args) {

        new NIOStream().fileChannelRead();
        new NIOStream().fileChannelWrite();

    }

    public void fileChannelRead() {

        try {

            //打开fileChannel文件
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileReadPath, mode);
            FileChannel inChannel = randomAccessFile.getChannel();

            //分配buffer空间存储文件内容
            ByteBuffer buffer = ByteBuffer.allocate(2048);

            byte[] b = new byte[2048];

            //从buffer中读取文件内容放在FileChannel
            //int len = inChannel.read(buffer);
            int tmp = 0;
            while ((tmp = inChannel.read(buffer)) != -1) {
                System.out.println(tmp);
            }
            inChannel.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

    public void fileChannelWrite() {
        //打开fileChannel文件
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(fileWritePath, mode);

            FileChannel writeChannel = randomAccessFile.getChannel();

            String data = "hello world";
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(data.getBytes());

            buf.flip();

            while (buf.hasRemaining()) {
                writeChannel.write(buf);
                System.out.println(writeChannel);
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


    }
}
