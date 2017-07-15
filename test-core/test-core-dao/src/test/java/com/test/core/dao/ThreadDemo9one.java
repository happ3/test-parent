package com.test.core.dao;

import java.util.HashMap;
import java.util.Random;

public class ThreadDemo9one {
	private static HashMap<Thread,Integer> data = new HashMap<Thread,Integer>();
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				public void run() {
					int vaule = new Random().nextInt(1000);
					data.put(Thread.currentThread(), vaule);
					
					A ai =new A();
					ai.getDate();
					
					B b =new B();
					b.getDate();
					C c = new C();
					c.getDate();
				}
			}).start();
		}
	}
	
	static class A {
		public void getDate(){
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+"from A is " +data.get(t));
		}	
	}
	static class B {
		public void getDate(){
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+"from b is " +data.get(t));
		}	
	}
	static class C {
		public void getDate(){
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+"from c is " +data.get(t));
		}	
	}
}
