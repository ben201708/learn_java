package com.thread2;

/**
 * 消费者
 *
 * @User: benhuang
 * @Date: 2017/9/24
 * @Time: 13:35
 */
public class Consumer implements Runnable {

    SyncData syncData = null;

    Consumer(SyncData syncData) {
        this.syncData = syncData;
    }

    @Override
    public void run() {
        System.out.println("当前线程：" + Thread.currentThread() + "，开始--->");
        // 消费
        for (int i = 0; i <= 30; i++) {

            Data data = syncData.get();// 从生产者中获取数据
            System.out.println("当前线程：" + Thread.currentThread() + "，消费了--->" + data.toString());
            /*
            try {
                //消费一个睡眠随机时间
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

    }
}
