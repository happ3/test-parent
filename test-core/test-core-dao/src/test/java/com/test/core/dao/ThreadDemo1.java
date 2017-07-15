package com.test.core.dao;


public class ThreadDemo1 {
	public static void main(String[] args) {
		
		Thread thread = new Thread(new A());
		thread.start();
		
		
		
		for(;;){//主函数本身也是一个线程
			System.out.println("主线程");
		}
		//两个线程都是在运行的   其实是所有线程在切换运行
		//(cpu)在点时刻只运行一个线程,
	}
	
}
//内部类
class A implements Runnable{

	@Override
	public void run() {//线程要执行的任务
		for(;;){
			System.out.println("次线程");
		}
	}
	
}