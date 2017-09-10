package com.io;

import java.io.*;

/**
 * @User: benhuang
 * @Date: 2017/9/11
 * @Time: 1:15
 */
public class TestBufferWriter {
    private static final String fileWriterPath = "E:/server_java/learn_java/src/com/io/555.txt";
    private static final String fileReaderPath = "E:/server_java/learn_java/src/com/io/111.txt";

    public static void main(String[] args) {
        new TestBufferWriter().buffer();
    }

    private String buffer() {


        try {
            FileWriter fw = new FileWriter(fileWriterPath);
            FileReader fr = new FileReader(fileReaderPath);
            BufferedWriter bw = new BufferedWriter(fw);
            BufferedReader br = new BufferedReader(fr);

            String s = null;
            for (int i = 0; i <= 100; i++) {
                s = String.valueOf(Math.random());
                bw.write(s);
                bw.newLine();
            }

            bw.flush();

            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            bw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
