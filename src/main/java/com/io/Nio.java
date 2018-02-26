package com.io;


import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

public class Nio {

    private static int port;
    private static ServerSocketChannel server;

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    private static Selector selector;
    private Map<SelectionKey, String> sessionMsg = new HashMap<SelectionKey, String>();

    public Nio(int port) {
        try {
            this.port = port;
            server = ServerSocketChannel.open();
            server.socket().bind(new InetSocketAddress(this.port));
            server.configureBlocking(false);
            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);
            selector.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listener() {
        while(true){

        }
    }


    public void process() {

    }

}
