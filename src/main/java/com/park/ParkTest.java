package com.park;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {

    Object oj = new Object();

    /**
     * 有严格的执行顺序限制
     */
    @Test
    public void testSynchronized() {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000l);
                    synchronized (oj) {
                        System.out.println("aa我在等某人~");
                        oj.wait();
                        System.out.println("aa一起约会去了~");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (oj) {
                    oj.notifyAll();
                    System.out.println("aa某人出现了~");
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 没有执行顺序限制
     */
    @Test
    public void testParkUnpark() {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我在等某人~");
                LockSupport.park();
                System.out.println("一起约会去了~");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.unpark(thread1);
                System.out.println("某人出现了~");
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
