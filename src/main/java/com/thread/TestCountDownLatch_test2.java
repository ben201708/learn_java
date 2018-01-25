package com.thread;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;


/**
 * 并发测试工具
 *
 * @author Benhuang
 * @version 2.0.0
 * @date 2017年2月7日 上午1:33:33
 */
public class TestCountDownLatch_test2 {

    private static CountDownLatch cd1;

    @Test
    public void test() {

        int len = 1000;

        cd1 = new CountDownLatch(len);

        final ConcurrentHashMap<String, String> param = new ConcurrentHashMap<String, String>();

        for (int i = 0; i < len; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Random random = new Random();

                    param.put(String.valueOf(random.nextInt()) + random.nextInt(), Thread.currentThread().getName());

                    System.out.println("当前线程：" + Thread.currentThread().getName() + "，CountDownLatch：" + cd1.getCount());
                    cd1.countDown();
                }
            });

            thread.start();
        }

        try {
            cd1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("当前主线程结果：" + JSON.toJSONString(param) + "，总数为：" + param.size());

    }

}
