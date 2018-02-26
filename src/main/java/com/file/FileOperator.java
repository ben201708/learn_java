package com.file;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileOperator {

    private final int SPLIT_SIZE = 10;
    private static final String fileSplitPath = "F:/server_java/learn/learn_java/src/main/java/com/file/split";
    private static final String path = "F:/server_java/learn/learn_java/src/main/java/com/file/111.txt";
    private static final String fileMergePath = "F:/server_java/learn/learn_java/src/main/java/com/file/merge";

    public static void main(String[] args) {

        new FileOperator().splitFile(path);

    }

    //拆分文件
    private void splitFile(String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));

            List<Integer> list = new ArrayList<Integer>();

            int count = 0;
            String data;


            while (true) {
                data = br.readLine();
                if (null != data) {
                    list.add(Integer.valueOf(data));
                    count++;
                    if (count > SPLIT_SIZE) {
                        System.out.println("需要拆分文件");
                        writeFile(fileSplitPath, list);
                        count = 0;
                        list.clear();
                    }
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeFile(String path, List<Integer> list) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        //构造小文件名称
        String fileName = path + "/data_" + System.nanoTime();

        //内排序
        Collections.sort(list);

        //写文件
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            for (Integer in : list) {
                bw.write(in + "\r\n");
            }
            bw.flush();
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //内部排序
    private void internalSort() {

    }

    //多个小文件归并
    private void mergeFile() throws IOException {
        File[] files = new File(fileSplitPath).listFiles();

        List<FileInfo> fileList = new ArrayList<FileInfo>();

        for (File file : files) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            FileInfo fileInfo = new FileInfo();
            //fileInfo.setReader(br);

        }

    }
}
