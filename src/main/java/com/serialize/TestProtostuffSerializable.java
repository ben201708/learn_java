package com.serialize;

import java.util.*;

public class TestProtostuffSerializable {


    private static final String filePath = "E:/server_java/learn_java/src/main/java/com/serialize/file/file_protostuff.bin";


    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        byte[] serializerResult = ProtoStuffUtil.serializer(list);

        System.out.println("serializer result:" + Arrays.toString(serializerResult));

        List<String> deSerializerResult = ProtoStuffUtil.deserializer(serializerResult, ArrayList.class);

        for (String res : deSerializerResult) {
            System.out.println("deSerializerResult:" + res);
        }


    }

}
