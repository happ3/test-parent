package com.test.core.dao;
/**
 * 线程资源共享问题
 * @author lin
 *
 */
public class ThreadDemo8 {
	
	public static void main(String[] args) {
		Abc a = new Abc();
		
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(a);
		t1.start();
		t2.start();
	}
}
/**
 * 解释 两个人给你打钱,一次打1元  各自打10   收到应该是20元
 * @author Administrator
 *
 */
class Abc implements Runnable {
	private int j;

	@Override
	public void run() {
		int h;
		for (int i = 1; i <= 10; i++) {
			synchronized (this) {
				h = j + 1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				j = h;
			}// 出同步块 就会释放钥匙
			System.out.println(j);
		}

	}
}