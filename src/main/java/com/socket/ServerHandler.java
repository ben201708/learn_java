package com.socket;


import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
            in = new BufferedInputStream(this.socket.getInputStream());
            out = new BufferedOutputStream(this.socket.getOutputStream());

            String body = null;
            while (in.read() != -1) {
                body += in.read() + "";
            }

            String currentTime = "QUERY TIME".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD TIME";

            byte[] by = currentTime.getBytes();
            out.write(by);

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
