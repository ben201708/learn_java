package com.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;

/**
 * @User: benhuang
 * @Date: 2017/9/17
 * @Time: 23:20
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    ChannelHandlerContext ctx;

    /**
     * tcp链路简历成功后调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
    }

    public boolean sendMsg(String msg) {
        System.out.println("客户端发送消息：" + msg);
        byte[] req = msg.getBytes();
        ByteBuf m = Unpooled.buffer(req.length);
        m.writeBytes(req);
        ctx.writeAndFlush(m);
        return msg.equals("quit") ? false : true;//循环发送消息，直到发送quit，则退出循环
    }

    /**
     * 收到服务器消息后调用
     *
     * @throws UnsupportedEncodingException
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "utf-8");
        System.out.println("服务器消息：" + body);
    }

    /**
     * 发生异常时调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}