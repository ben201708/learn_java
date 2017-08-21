package com.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * [1]线程内共享数据
 * 
 * @author Ben
 *
 */
public class TestThreadScopeShareData5 {

	private static int data = 0;
	private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();

	public static void main(String[] args) {

		for (int i = 0; i <= 1; i++) {
			new Thread(new Runnable() {
				public void run() {

					data = new Random().nextInt(300);
					System.out.println(Thread.currentThread().getName() + "|current thread data:" + data);
					threadData.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}

	}

	static class A{
		public void get() {
			int data = threadData.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName() + "|A current thread data:" + data);
		} 
	}
	
	static class B{
		public void get() {
			int data = threadData.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName() + "|B current thread data:" + data);
		} 
	}

}
