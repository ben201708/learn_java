package com.serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * java Kyro序列化
 *
 * @User: benhuang
 * @Date: 2017/10/15
 * @Time: 10:45
 */
public class TestKryoSerializable {

    private static final String filePath = "E:/server_java/learn_java/src/main/java/com/serialize/file/file_kryo.bin";

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        setSerialize();
        System.out.println("java Kryo序列化时间" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        getSerialize();

        System.out.println("java Kryo反序列化时间" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void setSerialize() {
        try {
            DefaultSerializers.KryoSerializableSerializer kyro = new DefaultSerializers.KryoSerializableSerializer();

            FileOutputStream f = new FileOutputStream(filePath);
            Output output = new Output(f);

            Kryo kryo = new Kryo();
            kryo.setDefaultSerializer(CompatibleFieldSerializer.class);

            for (int i = 0; i < 10000; i++) {
                HashMap<String, Integer> data = new HashMap<String, Integer>(2);
                data.put("age1", i);
                data.put("age2", i);
                kryo.writeObject(output, data);
            }
            output.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void getSerialize() {

        try {
            FileInputStream f = new FileInputStream(filePath);

            Input input = new Input(f);

            Kryo kryo = new Kryo();
            kryo.setDefaultSerializer(CompatibleFieldSerializer.class);

            while (null != kryo.readObject(input, HashMap.class)) {
                //System.out.println(data);
            }

            f.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            //System.out.println("Exception:" + e.getMessage());
            //e.printStackTrace();
        }
    }

}
