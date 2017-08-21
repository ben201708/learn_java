package com.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 * Semaphore信号灯测试
 *
 * @author Benhuang
 * @date 2017年2月7日 上午12:55:20
 * @version 2.0.0
 */
public class TestSemaphore14 {

    private static int times = 3;

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(TestSemaphore14.times);

        for (int i = 0; i < 10; i++ ) {
            Runnable runnable = new Runnable() {

                @Override
                public void run() {

                    try {
                        semaphore.acquire();
                    }
                    catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "进入，当前已有："
                                       + (TestSemaphore14.times - semaphore.availablePermits())
                                       + "个并发");

                    try {
                        Thread.sleep((long)Math.random() * 10000);
                    }
                    catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
                    semaphore.release();

                    // 下面代码有时候执行不准确，因为没有合上面的代码合成原子单元
                    System.out.println("线程" + Thread.currentThread().getName() + "已离开，当前已有"
                                       + (TestSemaphore14.times - semaphore.availablePermits())
                                       + "个并发");

                }
            };

            service.execute(runnable);
        }
        service.shutdown();
    }
}
