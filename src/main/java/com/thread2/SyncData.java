package com.thread2;

/**
 * @User: benhuang
 * @Date: 2017/9/24
 * @Time: 13:35
 */
public class SyncData {

    int index = 0;
    Data[] data = new Data[6];

    /**
     * 添加数据
     *
     * @param d
     */
    public synchronized void set(Data d) {
        while (index == data.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        data[index] = d;
        index++;
    }

    /**
     * 获取数据
     *
     * @return
     */
    public synchronized Data get() {

        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.notify();

        index--;
        return data[index];
    }
}
