package com.io;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @User: benhuang
 * @Date: 2017/9/11
 * @Time: 1:03
 */
public class TestFileReader {
    private static final String fileInPath = "E:/server_java/learn_java/src/com/io/111.txt";

    public static void main(String[] args) {
        new TestFileReader().read();
    }

    private String read() {

        try {
            FileReader fileReader = new FileReader(fileInPath);

            int b = 0;
            while ((b = fileReader.read()) != -1) {
                System.out.println((char) b);
            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
