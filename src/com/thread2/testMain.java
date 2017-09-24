package com.thread2;

/**
 * @User: benhuang
 * @Date: 2017/9/25
 * @Time: 1:04
 */
public class testMain {

    public static void main(String[] args) {

        SyncData sd = new SyncData();

        Producer producer = new Producer(sd);
        Consumer consumer = new Consumer(sd);

        //生产者
        Thread threadProducer = new Thread(producer);
        threadProducer.start();

        //消费者
        Thread threadConsumer = new Thread(consumer);
        threadConsumer.start();
    }
}
