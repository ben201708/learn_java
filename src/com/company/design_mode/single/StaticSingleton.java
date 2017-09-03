package com.company.design_mode.single;

/**
 * 单例模式
 */
public class StaticSingleton {

    private StaticSingleton() {
        System.out.println("StaticSingleton单例模式");
    }

    //内部类实现
    //当StaticSingleton被加载入jvM时，不会初始化单例类，而当getInstance被调用时，
    //才会加载SingletonHolder方法，从而初始化instance
    //同时由于实例的建立是在类加载时完成，故天生对多线程友好
    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        StaticSingleton.getInstance();
        StaticSingleton.getInstance();
        StaticSingleton.getInstance();
    }
}

