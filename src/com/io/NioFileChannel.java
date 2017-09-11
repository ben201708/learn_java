package com.io;


import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @User: benhuang
 * @Date: 2017/9/9
 * @Time: 12:38
 */
public class NioFileChannel {

    private static final String fileReadPath = "E:/server_java/learn_java/src/com/io/111.txt";
    private static final String fileWritePath = "E:/server_java/learn_java/src/com/io/666.txt";

    private static final String mode = "rw";

    public static void main(String[] args) {

        //new NioFileChannel().fileChannelRead();
        new NioFileChannel().fileChannelWrite();

    }

    public void fileChannelRead() {

        try {

            //打开fileChannel文件
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileReadPath, mode);
            FileChannel inChannel = randomAccessFile.getChannel();

            //分配buffer空间存储文件内容
            ByteBuffer buffer = ByteBuffer.allocate(2048);

            //从buffer中读取文件内容放在FileChannel
            int byteRead = inChannel.read(buffer);

            // 反转此缓冲区。limit=position, position=0，如果已定义了标记，则丢弃该标记。将数据从一个地方传输到另一个地方时，经常将此方法与 compact 方法一起使用。
            buffer.flip();

            while (byteRead != -1) {
                while (buffer.hasRemaining()) {
                    System.out.println("read：" + (char) buffer.get());
                }

                // 清除此缓冲区。position = 0，limit=capacity，并且丢弃标记。此方法不能实际擦除缓冲区中的数据，但从名称来看似乎能够擦除，因为它多数情况下确实是在擦除数据时使用的。
                buffer.clear();

                byteRead = inChannel.read(buffer);
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

            String data = "hello world asdas";
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(data.getBytes());

            buf.flip();

            while (buf.hasRemaining()) {
                writeChannel.write(buf);
                System.out.println("wirte:" + writeChannel);
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


    }
}
