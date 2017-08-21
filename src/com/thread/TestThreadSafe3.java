package com.thread;

/**
 * [3]线程互斥
 * 
 * @author Ben
 *
 */
public class TestThreadSafe3 {

	public static void main(String[] args) {

		final TestThreadSafe3 testThreadSafe = new TestThreadSafe3();

		// 线程1
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
						testThreadSafe.init("benhuang");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

		// 线程2
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
						testThreadSafe.init("helloword");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

	private void init(String name) {
		OutPuter outPuter = new OutPuter();
		outPuter.output(name);
	}

	class OutPuter {
		private String xxx = "";

		public void output(String name) {
			int len = name.length();

			synchronized (xxx) {
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
	}
}
