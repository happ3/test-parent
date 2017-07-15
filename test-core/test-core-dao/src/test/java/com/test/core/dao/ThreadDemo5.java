package com.test.core.dao;

public class ThreadDemo5 {
	public static void main(String[] args) {
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2);
		thread.start();
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}


class MyThread2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i <=10; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
	//			e.printStackTrace();
				System.out.println("线程中断");
			}
			System.out.println("hello");
		}
	}
}
