package com.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @User: benhuang
 * @Date: 2017/9/11
 * @Time: 1:15
 */
public class TestBufferStream {
    private static final String fileInPath = "E:/server_java/learn_java/src/com/io/111.txt";

    public static void main(String[] args) {
        new TestBufferStream().buffer();
    }

    private String buffer() {


        try {
            FileInputStream in = new FileInputStream(fileInPath);
            BufferedInputStream bin = new BufferedInputStream(in);

            bin.read();

            int f = 0;
            bin.mark(1);
            for (int i = 0; i <= 10 && ((f = in.read()) != -1); i++) {
                System.out.println((char)f+" ");
            }
            System.out.println();
            bin.reset();
            for (int i = 0; i <= 10 && ((f = in.read()) != -1); i++) {
                System.out.println((char)f+" ");
            }
            bin.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
