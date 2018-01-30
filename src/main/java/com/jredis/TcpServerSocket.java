package com.jredis;


import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpServerSocket {

    private Socket socket;
    private InputStream read;
    private OutputStream write;

    @Test
    public void mainTest() {
        this.redisServerSocket();

        String aa = this.set("bello", "w2e");

        String bb = this.get("bello");

        System.out.println("redis设置成功：" + aa);
        System.out.println("redis设置的值为：" + bb);
        System.exit(1);
    }


    public void redisServerSocket() {
        try {

            socket = new Socket(RedisConfig.host, RedisConfig.port);

            read = socket.getInputStream();
            write = socket.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String set(String key, String value) {

        StringBuilder stringBuilder = new StringBuilder();

        //设置密码
        stringBuilder.append("*2").append("\r\n");
        stringBuilder.append("$4").append("\r\n");
        stringBuilder.append("AUTH").append("\r\n");
        stringBuilder.append("$8").append("\r\n");
        stringBuilder.append(RedisConfig.auth).append("\r\n");

        stringBuilder.append("*3").append("\r\n");
        stringBuilder.append("$3").append("\r\n");
        stringBuilder.append("SET").append("\r\n");
        stringBuilder.append("$" + key.getBytes().length).append("\r\n");
        stringBuilder.append(key).append("\r\n");
        stringBuilder.append("$" + value.getBytes().length).append("\r\n");
        stringBuilder.append(value).append("\r\n");

        return this.command(stringBuilder.toString());
    }

    private String get(String key) {

        StringBuilder stringBuilder = new StringBuilder();

        //设置密码
        stringBuilder.append("*2").append("\r\n");
        stringBuilder.append("$4").append("\r\n");
        stringBuilder.append("AUTH").append("\r\n");
        stringBuilder.append("$8").append("\r\n");
        stringBuilder.append(RedisConfig.auth).append("\r\n");

        stringBuilder.append("*3").append("\r\n");
        stringBuilder.append("$3").append("\r\n");
        stringBuilder.append("GET").append("\r\n");
        stringBuilder.append("$" + key.getBytes().length).append("\r\n");
        stringBuilder.append(key).append("\r\n");

        return this.command(stringBuilder.toString());
    }


    public String command(String s) {
        //发送server
        try {
            write.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //接收server
        byte[] bytes = new byte[1024];
        try {
            read.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(bytes);
    }
}
