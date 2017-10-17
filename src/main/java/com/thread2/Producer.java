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
        // 生产
        for (int i = 0; i <= 100; i++) {
            Data data = new Data();
            data.setId(i);
            syncData.set(data);// 往篮子里装东西
            System.out.println("当前线程：" + Thread.currentThread() + "，生产了--->" + data.toString());
            try {
                Thread.sleep(3000);//每生产一个睡眠一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
