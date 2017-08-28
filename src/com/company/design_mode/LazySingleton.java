package com.company.design_mode;

/**
 * 延迟加载单例模式
 */
public class LazySingleton {

    private LazySingleton() {
        System.out.println("LazySingleton单例模式");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}

