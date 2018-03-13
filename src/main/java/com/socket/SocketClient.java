package com.socket;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {

        int port = 8080;
        String host = "127.0.0.1";
        Socket socket = null;
        try {
            socket = new Socket(host, port);
            System.out.println("开始socket");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
