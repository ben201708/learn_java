package com.io;

import java.io.*;

/**
 * @User: benhuang
 * @Date: 2017/9/8
 * @Time: 11:43
 */
public class IOStream {

    private static final String filePath = "E:/server_java/learn_java/src/com/io/111.txt";

    public static void main(String[] args) {
        new IOStream().getStreamByFileSize();
        new IOStream().getStreamByFileEnd();
    }

    //通过文件大小读取文件
    private String getStreamByFileSize() {

        File f = new File(filePath);

        InputStream input = null;
        try {

            //字符流读取文件
            input = new FileInputStream(f);
            char b[] = new char[(int) f.length()];

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            bufferedReader.read(b);
            bufferedReader.close();
            System.out.println("读取数据：" + new String(b));


            //字节流读取文件
            InputStream in = new FileInputStream(f);
            byte c[] = new byte[(int) f.length()];     //创建合适文件大小的数组
            in.read(c);    //读取文件中的内容到b[]数组
            in.close();
            System.out.println("读取数据：" + new String(c));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //通过判断文件结尾来读取文件
    public void getStreamByFileEnd() {
        File f = new File(filePath);

        try {
            InputStream in = new FileInputStream(f);
            byte b[] = new byte[1024];
            int len = 0;
            int tmp = 0;
            while ((tmp = in.read()) != -1) {
                b[len] = (byte) tmp;
                len++;
            }
            in.close();
            System.out.println("数据：" + new String(b, 0, len));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
