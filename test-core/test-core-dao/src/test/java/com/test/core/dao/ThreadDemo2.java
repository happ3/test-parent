package com.test.core.dao;

public class ThreadDemo2 {
	
	public static void main(String[] args) {
		
		MyThread t1 = new MyThread();
		t1.start();
	}
	
	
}

class MyThread extends Thread{
	@Override
	public void run() {
		
		for(;;){
			System.out.println("hello word");
		}
		
	}
}
