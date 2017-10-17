package com.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * [2]定时器
 * 
 * @author Ben
 *
 */
public class TestTime2 {

	@SuppressWarnings("deprecation")
    public static void main(String[] args) {

		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("boming");
			}
		}, 10000, 3000);

		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
