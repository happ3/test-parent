package com.test.core.dao;

public class ThreadDemo3 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(;;){
					System.out.println("hello word");
				}
			}
		}).start();
		
		new Thread(){
			public void run() {
				for(;;){
					System.out.println("h");
				}
			};
		}.start();
	}
}
