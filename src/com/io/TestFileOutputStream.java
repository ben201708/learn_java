package com.io;

import java.io.*;

/**
 * @User: benhuang
 * @Date: 2017/9/8
 * @Time: 11:43
 */
public class TestFileOutputStream {

    private static final String fileInPath = "E:/server_java/learn_java/src/com/io/111.txt";
    private static final String fileOutPath = "E:/server_java/learn_java/src/com/io/222.txt";

    public static void main(String[] args) {
        new TestFileOutputStream().output();
    }


    private String output() {

        try {
            FileInputStream fileInputStream = new FileInputStream(fileInPath);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutPath);

            int b = 0;
            while ((b = fileInputStream.read()) != -1) {
                fileOutputStream.write(b);
            }
            fileInputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


}
