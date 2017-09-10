package com.io;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;

/**
 * @User: benhuang
 * @Date: 2017/9/11
 * @Time: 1:03
 */
public class TestFileWriter {
    private static final String fileInPath = "E:/server_java/learn_java/src/com/io/333.txt";

    public static void main(String[] args) {
        new TestFileWriter().write();
    }

    private String write() {

        try {
            FileWriter fileWriter = new FileWriter(fileInPath);

            for (int i = 0; i <= 50000; i++) {
                fileWriter.write(i);
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
