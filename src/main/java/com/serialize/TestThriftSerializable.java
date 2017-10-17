package com.serialize;


import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Java Thrift序列化和反序列化方式
 *
 * @User: Benhuang
 * @Date: 2017/10/17
 * @Time: 7:48
 */
public class TestThriftSerializable {

    private static final String filePath = "E:/server_java/learn_java/src/main/java/com/serialize/file/file_thrift.bin";

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        setSerializableObject();
        System.out.println("java thrift序列化时间" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        getSerializableObject();
        System.out.println("java thrift反序列化时间" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void setSerializableObject() {
        try {

            FileOutputStream out = new FileOutputStream(filePath);
            //ByteArrayOutputStream out = new ByteArrayOutputStream();
            TTransport transport = new TIOStreamTransport(out);
            TBinaryProtocol tp = new TBinaryProtocol(transport);//二进制编码格式进行数据传输

            for (int i = 0; i < 10000; i++) {
                Map<String, Integer> map = new HashMap<String, Integer>(2);
                map.put("age1", i);
                map.put("age2", i);

                //JSONObject jsonObject = JSONObject.fromObject(map);
                tp.writeString(map.toString());
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TException e) {
            System.out.println("TException Set:" + e.getMessage());
            //e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            //e.printStackTrace();
        }
    }

    public static void getSerializableObject() {

        try {
            FileInputStream f = new FileInputStream(filePath);
            TTransport transport = new TIOStreamTransport(f);
            TBinaryProtocol tp = new TBinaryProtocol(transport);

            String data = null;
            while (null != (data = tp.readString())) {
                //System.out.println(data);
            }
            f.close();
            transport.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TException e) {
            System.out.println("TException Get:" + e.getMessage());
            //e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            //e.printStackTrace();
        }
    }

}
