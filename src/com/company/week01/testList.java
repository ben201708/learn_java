package com.company.week01;

import java.util.*;

/**
 * 比较ArrayList，LinkList查询效率
 */
public class testList {
    private final static Integer max = 10000;
    private final static Integer addMax = 10000;

    public static void main(String[] args) {
        //查询效率对比
        //queryList();
        //添加效率对比
        addList();
    }

    private static String getRandStr(int len){
        String str =  "abcdefghijklmnopqrstuvwxyz0123456789";

        Random ra=new Random();
        StringBuffer s = new StringBuffer();
        for (int i=0;i<len;i++){
            int num = ra.nextInt(str.length());
            s.append(str.charAt(num));
        }
        return s.toString();
    }

    private static void queryList() {
        //ArrayList
        List ls = new ArrayList<Integer>();

        Integer i;
        for (i = 0; i < max; i++) {
            ls.add(getRandStr(i));
        }

        Long startTime = System.currentTimeMillis();
        for (i = 0; i < max; i++) {
            ls.get(i);
        }
        Long endTime = System.currentTimeMillis();

        System.out.println("ArrayList query:" + (endTime - startTime));


        //LinkList
        List linkList = new LinkedList<Integer>();

        Integer j;
        for (j = 0; j < max; j++) {
            linkList.add(Math.random());
        }

        Long startTimeL = System.currentTimeMillis();
        for (j = 0; j < max; j++) {
            linkList.get(j);
        }
        Long endTimeL = System.currentTimeMillis();

        System.out.println("LinkedList query:" + (endTimeL - startTimeL));
    }

    private static void addList() {
        //ArrayList
        List ls = new ArrayList<Integer>();

        Integer i;
        for (i = 0; i < addMax; i++) {
            ls.add(getRandStr(addMax));
        }

        Long startTime = System.currentTimeMillis();
        for (i = 0; i < addMax; i++) {
            Integer index = (int)Math.floor(Math.random()*addMax);
            if (!index.equals(100)){
                continue;
            }
            ls.set(index, getRandStr(addMax));
            //ls.add(index, getRandStr(addMax));
        }
        Long endTime = System.currentTimeMillis();

        System.out.println("ArrayList add:" + (endTime - startTime));


        //LinkList
        List linkList = new LinkedList<Integer>();

        Integer j;
        for (j = 0; j < addMax; j++) {
            linkList.add(getRandStr(addMax));
        }

        Long startTimeL = System.currentTimeMillis();
        for (j = 0; j < addMax; j++) {
            Integer index = (int)Math.floor(Math.random()*addMax);
            if (!index.equals(100)){
                continue;
            }
            linkList.set(index, getRandStr(addMax));
            //linkList.add(index, getRandStr(addMax));
        }
        Long endTimeL = System.currentTimeMillis();

        System.out.println("LinkedList add:" + (endTimeL - startTimeL));
    }
}
