package com.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * [4]线程通信
 * 
 * @author Ben
 */
public class TestConditionCommunicate13 {

    public static void main(String[] args) {

        final Bussiness bussiness = new Bussiness();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++ ) {
                    bussiness.sub(i);
                }
            }
        }).start();

        for (int i = 1; i <= 5; i++ ) {
            bussiness.main(i);
        }

    }

    static class Bussiness {

        final Lock lock = new ReentrantLock();

        final Condition condition = lock.newCondition();

        private boolean isSubStatus = false;

        public void sub(Integer i) {
            lock.lock();

            try {
                while (!isSubStatus) {
                    try {
                        condition.await();
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
                condition.signal();
            }
            finally {
                lock.unlock();
            }

        }

        public void main(Integer i) {
            lock.lock();
            
            try {
                while (isSubStatus) {
                    try {
                        condition.await();
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
                condition.signal();
            }
            finally {
                lock.unlock();
            }
            
        }
    }

}
