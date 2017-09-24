package com.thread2;

/**
 * 生产者
 *
 * @User: benhuang
 * @Date: 2017/9/24
 * @Time: 13:35
 */
public class Producer implements Runnable {

    SyncData syncData = null;

    Producer(SyncData syncData) {
        this.syncData = syncData;
    }

    @Override
    public void run() {
        // 生产wt
        for (int i = 0; i <= 100; i++) {
            Data data = new Data();
            data.setId(i);
            syncData.set(data);// 往篮子里装东西
            System.out.println("生产了--->" + data);
            try {
                Thread.sleep(1000);//每生产一个睡眠一秒
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
