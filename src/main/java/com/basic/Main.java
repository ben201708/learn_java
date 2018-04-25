package com.basic;

public class Main {

    public static void main(String[] args) {
        String as = "sdfsd";

        Integer le = 1234;
        String out = getName(as, le);

        as = "sdfsdasfdf";
        String out2 = getName(as, le);

        System.out.println("输出内容为：" + out);
        System.out.println("输出内容为2：" + out2);
    }

    private static String getName(final String name, final Integer age) {
        return name;
    }

}
