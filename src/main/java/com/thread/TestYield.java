package com.thread;

public class TestYield {

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        Thread thread = new Thread(demo, "花花");
        Thread thread1 = new Thread(demo, "草草");
        thread.start();
        thread1.start();
    }
}

class ThreadDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                System.out.println("当前的线程是     " + Thread.currentThread().getName());
                Thread.currentThread().yield();
            }
            System.out.println("执行的是    " + Thread.currentThread().getName());
        }

    }
}
