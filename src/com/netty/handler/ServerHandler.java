package com.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;


/**
 * @User: benhuang
 * @Date: 2017/9/17
 * @Time: 23:20
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {

        ByteBuf in = (ByteBuf) msg;
        byte[] req = new byte[in.readableBytes()];
        in.readBytes( req );
        String body = new String( req, "utf-8" );

        System.out.println( "收到客户端消息:" + body );
        ctx.fireChannelRead( body);
//        System.out.println( "server received data :" + msg );
//        ByteBuf in = (ByteBuf) msg;
//        StringBuffer sb = new StringBuffer();
//
//        int i =0;
//        while (in.isReadable()){
//            sb.append( in.getByte(i));
//            i++;
//        }
//        ctx.fireChannelRead(sb);
//        ctx.write( msg );//写回数据
//    }
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //ctx.flush();
        ctx.writeAndFlush( Unpooled.EMPTY_BUFFER ) //flush掉所有写回的数据
                .addListener( ChannelFutureListener.CLOSE ); //当flush完成后关闭channel
    }

    /**
     * 异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();//捕捉异常信息
        ctx.close();//出现异常时关闭channel
    }
}
