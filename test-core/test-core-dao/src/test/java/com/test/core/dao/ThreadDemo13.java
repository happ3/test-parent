package com.test.core.dao;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo13 {
	public static void main(String[] args) {
	final Output3 output = new Output3();
		
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
class Output3 {
	Lock lock = new ReentrantLock();
	public void print(String name) {
		lock.lock();//当线程进来的时候,先锁住
		try {
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		} finally  {//finally  不管里面最终出现什么意外,都需要解锁  不然就等于死锁了
			lock.unlock();
		}
	}
}