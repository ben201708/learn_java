package com.serialize;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * java原生序列化
 *
 * @User: benhuang
 * @Date: 2017/10/15
 * @Time: 10:45
 */
public class TestNativeSerializable {
    private static final String filePath = "E:/server_java/learn_java/src/main/java/com/serialize/file/file_native.bin";

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        setSerializableObject();
        System.out.println("java原生序列化时间" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        getSerializableObject();
        System.out.println("java原生反序列化时间" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void setSerializableObject() {
        try {
            FileOutputStream f = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(f);

            for (int i = 0; i < 10000; i++) {
                Map<String, Integer> map = new HashMap<String, Integer>(2);
                map.put("age1", i);
                map.put("age2", i);
                out.writeObject(map);
            }
            out.flush();
            out.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            //e.printStackTrace();
        }
    }

    public static void getSerializableObject() {

        try {
            FileInputStream f = new FileInputStream(filePath);
            ObjectInputStream s = new ObjectInputStream(f);
            while (null != s.readObject()) {

            }
            f.close();
            s.close();

        } catch (IOException e) {
            //e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            //e.printStackTrace();
        }
    }
}
