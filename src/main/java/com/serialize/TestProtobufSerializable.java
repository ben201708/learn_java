package com.serialize;


import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ProtocolStringList;

import java.util.ArrayList;
import java.util.List;


/**
 * Java Protobuf序列化和反序列化方式
 * 参考文档：http://www.cnblogs.com/xiaoMzjm/p/4555209.html
 *
 * @User: Benhuang
 * @Date: 2017/10/17
 * @Time: 7:48
 */
public class TestProtobufSerializable {

    public static void main(String[] args) {

        //java Protobuf序列化时间
        List<byte[]> bytes = new TestProtobufSerializable().serializeProtoBufProductList();

        //java Protobuf反序列化时间
        new TestProtobufSerializable().deserializeProtoBufDataListToProductInfoList(bytes);

    }

    public List<byte[]> serializeProtoBufProductList() {

        long start = System.currentTimeMillis();

        Product.ProductInfo.Builder builder = Product.ProductInfo.newBuilder();
        List<Product.ProductInfo.Builder> builderList = new ArrayList<Product.ProductInfo.Builder>();

        for (int i = 0; i < 10000; i++) {
            builder.addList(String.valueOf(i));
        }
        //构建数据
        builderList.add(builder);

        //System.out.println(builderList);

        List<byte[]> bytesList = new ArrayList<byte[]>();
        for (Product.ProductInfo.Builder pBuilder : builderList) {
            Product.ProductInfo p = pBuilder.build();
            byte[] bytes = p.toByteArray();
            bytesList.add(bytes);
        }
        long end = System.currentTimeMillis();
        long usedTime = end - start;
        System.out.println("java Protobuf序列化时间" + usedTime + "ms");
        return bytesList;
    }

    public List<Product.ProductInfo> deserializeProtoBufDataListToProductInfoList(
            List<byte[]> bytesList) {
        long start = System.currentTimeMillis();
        List<Product.ProductInfo> list = new ArrayList<Product.ProductInfo>();
        for (byte[] b : bytesList) {
            try {
                list.add(Product.ProductInfo.parseFrom(b));
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        long usedTime = end - start;
        System.out.println("java Protobuf反序列化时间" + usedTime + "ms");

        //System.out.println(list);
        return list;
    }
}
