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

    private static final String filePath = "E:/server_java/learn_java/src/com/io/111.txt";

    private static final String mode = "rw";

    public static void main(String[] args) {

    }

    public void fileChannel() {

        try {

            //打开fileChannel文件
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, mode);
            FileChannel inChannel = randomAccessFile.getChannel();

            //分配buffer空间存储文件内容
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            byte[] b = new byte[1024];

            //从buffer中读取文件内容放在FileChannel
            //int len = inChannel.read(buffer);
            int tmp = 0;
            while ((tmp = inChannel.read(buffer)) != -1) {
                System.out.println(tmp);
            }


        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


    }
}
