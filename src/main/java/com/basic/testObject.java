package com.basic;

public class testObject {
    public static void main(String[] args) {

        Integer a = (1 - 1) & 2;
        Integer b = 1 - (1 & 2);
        Integer c=0-1&98306;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        Object o = new Object();

        o.hashCode();
        System.out.println(o.hashCode());

    }
}
