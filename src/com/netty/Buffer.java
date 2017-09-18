package com.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;

/**
 * @User: benhuang
 * @Date: 2017/9/18
 * @Time: 0:28
 */
public class Buffer {

    private static final byte[] CONTENT = new byte[100];

    public static void main(String[] args) {
        new Buffer().testBuffer();
        new Buffer().testPoolBuffer();
    }

    //基于内存池的非堆内存缓冲区测试用例
    public void testPoolBuffer() {

        int loop = 3000000;
        long startTime = System.currentTimeMillis();
        ByteBuf poolBuffer = null;

        for (int i = 0; i < loop; i++) {
            poolBuffer = PooledByteBufAllocator.DEFAULT.directBuffer( 1024 );
            poolBuffer.writeBytes( CONTENT );
            poolBuffer.release();
        }

        long endTime = System.currentTimeMillis();
        System.out.println( endTime - startTime );

    }

    //基于非内存池创建的非堆内存缓冲区测试用例
    public void testBuffer() {
        int loop = 3000000;
        long startTime = System.currentTimeMillis();
        ByteBuf buffer = null;

        for (int i = 0; i < loop; i++) {
            buffer = Unpooled.directBuffer( 1024 );
            ByteBuf byteBuf = buffer.writeBytes( CONTENT );
            buffer.release();
        }

        long endTime = System.currentTimeMillis();
        System.out.println( endTime - startTime );
    }
}
