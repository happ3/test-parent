package com.test.core.dao;

public class ThreadDemo12 {
	public static void main(String[] args) {
	final Output2 output = new Output2();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					output.print("hello");
				}
				
			}
		}).start();
		
		
	new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					output.print3("world");
				}
				
			}
		}).start();
	}
}	
/**
 * 注意第二个方法是带静态类型的 静态方法的锁对象是 类的类型 即Output.class
 * @author 
 *
 */
class Output2{
	public void print3(String name) {
		synchronized (Output2.class) {
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
	
	public static synchronized void print(String name) {
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
	}
	
}