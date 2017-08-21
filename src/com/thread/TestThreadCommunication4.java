package com.thread;


import java.util.concurrent.atomic.AtomicInteger;


/**
 * [4]线程通信
 * 
 * @author Ben
 */
public class TestThreadCommunication4 {

    private static AtomicInteger age = new AtomicInteger();// age成员变量的原子性操作

    public static void main(String[] args) {

        TestThreadCommunication4.getAge();

        final Bussiness bussiness = new Bussiness();

        Thread aThread =  new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++ ) {
                    bussiness.sub(i);
                }
            }
        });
        aThread.start();

        
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++ ) {
                    bussiness.main(i);
                }
            }
        }).start();
        

    }

    private static void getAge() {
        TestThreadCommunication4 testThreadCommunication4 = new TestThreadCommunication4();
        testThreadCommunication4.incrementAndGetAge();
    }

    /**
     * age成员变量的原子性操作
     * 
     * @see incrementAndGet
     */
    private void incrementAndGetAge() {
        age.set(12);

        age.incrementAndGet();
        System.out.println("age:" + age);
    }

}


class Bussiness {
    private boolean isSubStatus = false;

    public synchronized void sub(Integer i) {
        // TODO why?
        while (!isSubStatus) {
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        for (int j = 1; j <= 10; j++ ) {
            System.out.println("sub seq:" + j + "loop:" + i);
        }

        // TODO why?
        isSubStatus = false;
        
        this.notify();
    }

    public synchronized void main(Integer i) {
        while (isSubStatus) {
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        for (int j = 1; j <= 100; j++ ) {
            System.out.println("main seq:" + j + "loop:" + i);
        }

        isSubStatus = true;
        this.notify();
    }
}