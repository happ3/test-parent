package com.test.core.dao;

public class ThreadDemo11 {
	public static void main(String[] args) {
	final Output1 output = new Output1();
		
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
					output.print1("world");
				}
				
			}
		}).start();
	}
}	
/**
 * 这个例子中用的同样是一把锁  尽管是两个方法  但是第一个方法被调用了  第二个方法就无法被调用
 * @author 
 *
 */
class Output1{
	public  void print(String name) {
		synchronized (this) {   //用name 一把钥匙是hello  另一把钥匙 world
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
	
	public synchronized void print1(String name) {
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
	}
}