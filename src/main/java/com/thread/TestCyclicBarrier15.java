package com.thread;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * CyclicBarrier同步工具
 *
 * @author Benhuang
 * @date 2017年2月7日 上午1:18:24
 * @version 2.0.0
 */
public class TestCyclicBarrier15 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final CyclicBarrier cBarrier = new CyclicBarrier(3);

        for (int i = 0; i < 3; i++ ) {
            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    try {
                        // 集合点1
                        Thread.sleep((long)(Math.random() * 10000));
                        System.out.println(
                            "线程" + Thread.currentThread().getName() + "即将到达集合地点1，当前已有"
                                           + (cBarrier.getNumberWaiting() + 1) + "个已经到达，"
                                           + (cBarrier.getNumberWaiting() == 2 ? "都到齐了，继续走" : "正在等候"));
                        cBarrier.await();

                        // 集合点2
                        Thread.sleep((long)(Math.random() * 10000));
                        System.out.println(
                            "线程" + Thread.currentThread().getName() + "即将到达集合地点2，当前已有"
                                           + (cBarrier.getNumberWaiting() + 1) + "个已经到达，"
                                           + (cBarrier.getNumberWaiting() == 2 ? "都到齐了，继续走" : "正在等候"));
                        cBarrier.await();

                        // 集合点3
                        Thread.sleep((long)(Math.random() * 10000));
                        System.out.println(
                            "线程" + Thread.currentThread().getName() + "即将到达集合地点3，当前已有"
                                           + (cBarrier.getNumberWaiting() + 1) + "个已经到达，"
                                           + (cBarrier.getNumberWaiting() == 2 ? "都到齐了，继续走" : "正在等候"));
                        cBarrier.await();

                    }
                    catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        service.shutdown();
    }
}
