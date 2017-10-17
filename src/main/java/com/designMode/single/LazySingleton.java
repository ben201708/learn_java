package com.designMode.single;

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

    public static void main(String[] args) {

        Thread thread= new Thread();
        thread.run();

        LazySingleton.getInstance();
        LazySingleton.getInstance();
        LazySingleton.getInstance();
    }

}

