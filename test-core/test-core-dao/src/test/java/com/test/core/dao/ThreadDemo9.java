package com.test.core.dao;
/**
 * 线程资源共享问题
 * @author lin
 *
 */
public class ThreadDemo9 {
	
	public static void main(String[] args) {
		Abcd b = new Abcd();
		
		
		Thread t1 = new Thread(b);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
	}
}
/**
 * 解释 两个人给你打钱,一次打1元  各自打10   收到应该是20元
 * @author Administrator
 *
 */
class Abcd implements Runnable {
	private int j;

	@Override
	public synchronized void run() {
		int h;
		for (int i = 1; i <= 10; i++) {
				h = j + 1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				j = h;
			// 出同步块 就会释放钥匙
			System.out.println(j);
		}

	}
}