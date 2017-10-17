package com.serialize;

import java.io.IOException;
import java.io.Serializable;

/**
 * http://blog.csdn.net/wangshaolong20/article/details/52797514
 * @User: benhuang
 * @Date: 2017/10/16
 * @Time: 7:28
 */
public class TestSerializable implements Serializable {


    /*
    public void jdkSerialize(TestData testData) throws IOException,
            ClassNotFoundException {
        JdkSerialize jdkSerialize = new JdkSerialize();
        byte[] jdkByte = null;
        TestData deSerialize = null;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            jdkByte = jdkSerialize.serialize(testData);
            deSerialize = (TestData) jdkSerialize.deSerialize(jdkByte);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("jdk serialize:" + (endTime - startTime) + "ms");
    }

    public void kryoTest(TestData testData) {
        KryoSerialize kryoSerialize = new KryoSerialize();
        byte[] kryoByte = null;
        TestData kryObj = null;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            kryoByte = kryoSerialize.serialize(testData);
            kryObj = (TestData) kryoSerialize.deSerialize(kryoByte);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("kryo serialize:" + (endTime - startTime) + "ms");
    }

    public void protocolTest(){

        TestDataProto.TestData.Builder testData=TestDataProto.TestData.newBuilder();
        testData.setSn(8);
        byte[] datas = null;
        TestDataProto.TestData temp = null;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            datas = testData.build().toByteArray();
            try {
                temp =TestDataProto.TestData.parseFrom(datas);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("protocol serialize:" + (endTime - startTime) + "ms");

    }*/

}
