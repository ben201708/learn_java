package com.company.design_mode.single;

/**
 * 单例模式
 */
public class Singleton {

    private Singleton() {
        System.out.println("单例模式");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    public static void creatString() {
        System.out.println("creatString is Singleton");
    }

    public static void main(String[] args) {
        Singleton.creatString();
    }

}

