package com.company.week01;

import java.util.*;

/**
 * 比较ArrayList，LinkList查询效率
 */
public class testList {
    private final static Integer max = 10000;

    public static void main(String[] args) {
        //查询效率对比
        queryList();
        //添加效率对比
        addList();
    }

    private static void queryList() {
        //ArrayList
        List ls = new ArrayList<Integer>();

        Integer i;
        for (i = 0; i < max; i++) {
            ls.add(Math.random());
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
        for (i = 0; i < max; i++) {
            ls.add(Math.random());
        }

        Long startTime = System.currentTimeMillis();
        ls.add(0.232323);
        Long endTime = System.currentTimeMillis();

        System.out.println("ArrayList add:" + (endTime - startTime));


        //LinkList
        List linkList = new LinkedList<Integer>();

        Integer j;
        for (j = 0; j < max; j++) {
            linkList.add(Math.random());
        }

        Long startTimeL = System.currentTimeMillis();
        linkList.add(0.232323);
        Long endTimeL = System.currentTimeMillis();

        System.out.println("LinkedList add:" + (endTimeL - startTimeL));
    }
}
