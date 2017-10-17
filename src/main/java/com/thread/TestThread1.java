package com.thread;

/**
 * [1]线程回顾
 * @author Ben
 *
 */
public class TestThread1 {

	public static void main(String[] args) {
		
		//线程1
		Thread thread = new Thread() {
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						sleep(500);
						System.out.println(this.getName());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
		
		//线程2
		Thread thread2 = new Thread(){
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						sleep(500);
						System.out.println(this.getName());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		};
		thread2.start();
	}

}
