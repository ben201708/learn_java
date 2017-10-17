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
        Consumer consumer1 = new Consumer(sd);
        Consumer consumer2 = new Consumer(sd);
        Consumer consumer3 = new Consumer(sd);

        //生产者
        Thread threadProducer = new Thread(producer);
        threadProducer.start();

        //消费者
        Thread threadConsumer1 = new Thread(consumer1);
        threadConsumer1.start();

        //消费者
        Thread threadConsumer2 = new Thread(consumer2);
        threadConsumer2.start();

        //消费者
        Thread threadConsumer3 = new Thread(consumer3);
        threadConsumer3.start();
    }
}
