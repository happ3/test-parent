package com.test.core.dao;
/**
 * 寓意是要先输出1 2 3 ... 但是你在睡的这10秒钟,别人早就运行完了
 * @author lin
 *
 */
public class ThreadDemo7 {
public static void main(String[] args) throws InterruptedException {

	Mythread5 mythread3 = new Mythread5();
	mythread3.start();
	int j = 100;
	while (true) {
		Thread.yield(); //静态方法 主动放弃cpu 把机会分给别的线程  然后竞争Running
		if(j !=100){
			break;
		}
	}
	
	for (int i = 0; i <= 10; i++) {
		System.out.println("hello");
	}

}}

class Mythread5 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i <=10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}	
		
	}
}