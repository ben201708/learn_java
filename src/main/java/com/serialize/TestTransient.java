package com.serialize;

import com.alibaba.fastjson.JSON;
import com.spring.User;

import java.io.*;

/**
 * @User: benhuang
 * @Date: 2017/11/24
 * @Time: 16:22
 */
public class TestTransient {

    public static void main(String[] args) {

        UserTransient user = new UserTransient();
        user.setName("bensd");
        user.setPwd("werewerew");

        System.out.println("name:" + user.getName());
        System.out.println("pwd:" + user.getPwd());

        String FilePath = "E:/server_java/learn_java/src/main/java/com/serialize/file/file_transient.bin";

        //序列化
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FilePath);
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
            os.writeObject(user);

            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //反序列化
        try {
            FileInputStream fileInputStream = new FileInputStream(FilePath);
            ObjectInputStream os = new ObjectInputStream(fileInputStream);

            UserTransient obj = (UserTransient) os.readObject();

            os.close();

            System.out.println(JSON.toJSONString(obj));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
