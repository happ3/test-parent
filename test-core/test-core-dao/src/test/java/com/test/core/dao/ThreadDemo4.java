package com.test.core.dao;

public class ThreadDemo4 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
			}
		});
		thread.setName("xiancheng");
		System.out.println(thread.getName());
		System.out.println(Thread.currentThread().getName());//当前线程名字   Thread.currentThread()当前线程
		
		//如果线程没有设置优先级,其默认的的等级是5          没有设置最大最小等级,只能是1级到10级之间
		System.out.println(thread.getPriority());
		
		System.out.println(thread.MAX_PRIORITY);//最大等级
		System.out.println(thread.MIN_PRIORITY);//最小等级
		System.out.println(thread.NORM_PRIORITY);//普通等级
	}
}
