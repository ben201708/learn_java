package com.thread;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;


/**
 * 线程池+CountDownLatch
 *
 * @author Benhuang
 * @version 2.0.0
 * @date 2018年01月30日 上午9:44:01
 */
public class TestThreadPoolAndCountDownLatch {

    private ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
    private CountDownLatch countDownLatch;
    private ExecutorService threadPool = Executors.newFixedThreadPool(100); //固定数量线程池

    @Test
    public void test() {

        //初始化值
        Integer count = 4;
        countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            final Integer taskI = i;
            final Runnable runnable = new Runnable() {

                @Override
                public void run() {

                    try {
                        Thread.sleep(3000 * taskI);
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
            countDownLatch.await(7000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("success!!!map结果为：" + JSON.toJSONString(map));

        threadPool.shutdown();
    }
}
