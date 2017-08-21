package com.thread;


import java.util.Random;


public class TestThreadLocal6 {

    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();

    //private static ThreadLocal<ThreadScopeData> threadScopeData = new ThreadLocal<ThreadScopeData>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++ ) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data:" + data);
                    x.set(data);
                    /**
                     * ThreadScopeData myData = new ThreadScopeData(); myData.setName("name"+data);
                     * myData.setAge(data); threadScopeData.set(myData);//存入对象
                     */

                    ThreadScopeData.getThreadInstance().setName("name" + data);
                    ThreadScopeData.getThreadInstance().setAge(data);

                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            int data = x.get();
            System.out.println("A from " + Thread.currentThread().getName() + "get data:" + data);
            /**
             * ThreadScopeData myData = threadScopeData.get(); System.out.println("A from " +
             * Thread.currentThread().getName() + " getMyData:" + myData.getName() + "," +
             * myData.getAge());
             */
            ThreadScopeData myData = ThreadScopeData.getThreadInstance();
            System.out.println("A from " + Thread.currentThread().getName() + " getMyData:"
                               + myData.getName() + "," + myData.getAge());
        }
    }

    static class B {
        public void get() {
            int data = x.get();
            System.out.println("B from " + Thread.currentThread().getName() + " get data:" + data);
            /**
             * ThreadScopeData myData = threadScopeData.get(); System.out.println("A from " +
             * Thread.currentThread().getName() + " getMyData:" + myData.getName() + "," +
             * myData.getAge());
             */
            ThreadScopeData myData = ThreadScopeData.getThreadInstance();
            System.out.println("B from " + Thread.currentThread().getName() + " getMyData:"
                               + myData.getName() + "," + myData.getAge());
        }
    }

}


/**
 * 共享的数据类
 * 
 * @author Ben
 * @version 2017年1月17日
 * @see ThreadScopeData
 * @since
 */
class ThreadScopeData {

    // 不同线程操作，可以不需要加synchronized
    private static /* synchronized */ ThreadLocal<ThreadScopeData> map = new ThreadLocal<ThreadScopeData>();

    public static ThreadScopeData getThreadInstance() {
        ThreadScopeData instance = map.get();
        // 单例模式
        if (instance == null) {
            instance = new ThreadScopeData();
            map.set(instance);
        }

        return instance;
    }

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}