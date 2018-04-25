package com.thread;


import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


/**
 * 并发测试工具
 *
 * @author Benhuang
 * @version 2.0.0
 * @date 2017年2月7日 上午1:33:33
 */
public class TestCountDownLatch {

    //private static CountDownLatch cd1 = new CountDownLatch(10);
    private static CyclicBarrier cd1 = new CyclicBarrier(10);

    @Test
    public void test() {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println("当前线程：" + Thread.currentThread().getName());

                    //cd1.countDown();

                    try {
                        cd1.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    System.out.println("当前线程：" + Thread.currentThread().getName() + "，执行时间：" + System.currentTimeMillis());

                    return;
                }
            });

            thread.start();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
