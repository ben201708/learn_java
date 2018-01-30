package com.thread;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 线程池+CountDownLatch
 *
 * @author Benhuang
 * @version 2.0.0
 * @date 2018年01月30日 上午9:44:01
 */
public class TestThreadPoolAndCountDownLatch {

    @Test
    public void test() {

        //初始化值
        Integer count = 4;
        final ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
        final CountDownLatch countDownLatch = new CountDownLatch(count);

        ExecutorService threadPool = Executors.newFixedThreadPool(count); //固定数量线程池

        for (int i = 0; i < count; i++) {
            final Integer taskI = i;
            final Runnable runnable = new Runnable() {

                @Override
                public void run() {

                    try {
                        Thread.sleep(200);
                        map.put(taskI, Thread.currentThread().getName());
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("结束：" + Thread.currentThread().getName() + "，i:" + taskI + "，countDownVal：" + countDownLatch.getCount());

                }
            };

            threadPool.execute(runnable);
        }

        try {
            Thread.sleep(2000);
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("success!!!map结果为：" + JSON.toJSONString(map));

        threadPool.shutdown();
    }
}
