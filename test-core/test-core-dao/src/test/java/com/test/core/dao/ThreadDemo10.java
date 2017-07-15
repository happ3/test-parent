package com.test.core.dao;

public class ThreadDemo10 {
	public static void main(String[] args) {
	final Output output = new Output();
		
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
					output.print("world");
				}
				
			}
		}).start();
	}
}	
/**
 * 
 * @author 
 *
 */
class Output{
	public  void print(String name) {
		synchronized (this) {   //用name 一把钥匙是hello  另一把钥匙 world
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}