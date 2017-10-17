package com.thread;

public class TestMultiThreadShareData7 {

    public static void main(String[] args) {

        final ShareData sData = new ShareData();

        // 线程1
        new Thread(new Runnable() {
            @Override
            public void run() {
                sData.decrement();
                sData.decrement();
            }
        }) {}.start();

        // 线程2
        new Thread(new Runnable() {
            @Override
            public void run() {
                sData.increment();
            }
        }) {}.start();
    }

}


/**
 * 共享数据
 * 
 * @author Ben
 * @version 2017年1月20日
 * @see ShareData
 * @since
 */
class ShareData {

    private int count = 100;

    public void decrement() {
        count-- ;
        System.out.println(Thread.currentThread().getName() + "DE:" + count);
    }

    public void increment() {
        count++ ;
        System.out.println(Thread.currentThread().getName() + "IN:" + count);
    }
}