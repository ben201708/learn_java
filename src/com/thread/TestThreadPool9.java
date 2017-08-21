package com.thread;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 线程池
 *
 * @author Benhuang
 * @date 2017年2月7日 上午9:44:01
 * @version 2.0.0
 */
public class TestThreadPool9 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3); //固定数量线程池
        // ExecutorService threadPool = Executors.newCachedThreadPool();//动态创建的缓存线程池
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();// 动态创建的缓存线程池,好处：当前池子中的线程死掉，会自动创建一个线程。确保至少有一个线程
        for (int i = 0; i < 10; i++ ) {
            final Integer taskI = i;
            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 2; j++ ) {

                        try {
                            Thread.sleep(100);
                        }
                        catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        System.out.println(
                            Thread.currentThread().getName() + "i:" + taskI + "j:" + j);
                    }

                }
            };

            threadPool.execute(runnable);
            
        }

        // 线程池定时器
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println(Thread.currentThread().getName() + "|Bombing");
            }
        }, 10, 2, TimeUnit.SECONDS);

        // 设定明天凌晨3点的时间炸
        Date date = new Date();
        System.out.println("过期时间：" + date);
        System.out.println("过期时间S：" + (date.getTime() + 150 - System.currentTimeMillis()));

        Executors.newScheduledThreadPool(3).schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "|Bombing222");

            }
        }, date.getTime() + 150 - System.currentTimeMillis(), TimeUnit.SECONDS);

        threadPool.shutdown();
    }
}
