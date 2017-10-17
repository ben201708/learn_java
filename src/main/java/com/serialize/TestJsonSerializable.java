package com.serialize;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * java Json序列化
 *
 * @User: benhuang
 * @Date: 2017/10/15
 * @Time: 10:45
 */
public class TestJsonSerializable {
    private static final String filePath = "E:/server_java/learn_java/src/main/java/com/serialize/file/file_json.bin";

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        setSerializableObject();
        System.out.println("java json序列化时间" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        getSerializableObject();
        System.out.println("java json反序列化时间" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void setSerializableObject() {
        try {
            FileOutputStream f = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(f);

            for (int i = 0; i < 10000; i++) {
                Map<String, Integer> data = new HashMap<String, Integer>(2);
                data.put("age1", i);
                data.put("age2", i);
                out.writeObject(JSON.toJSONString(data));
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

            Object data = null;
            while (null != (data = s.readObject())) {
                //System.out.println(data);
                //Map<String, Integer> map = JSON.parseObject(data.toString(), HashMap.class);
                //System.out.println(map);
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
