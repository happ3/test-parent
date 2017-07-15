package com.test.core.dao;
/**
 * 寓意是要先输出1 2 3 ... 但是你在睡的这10秒钟,别人早就运行完了
 * @author lin
 *
 */
public class ThreadDemo6 {
public static void main(String[] args) throws InterruptedException {

	Mythread3 mythread3 = new Mythread3();
	mythread3.start();
	
	mythread3.join();//主线程等待mythread3运行结束     提高的了mythread3优先级
	for (int i = 0; i <= 10; i++) {
		System.out.println("hello");
	}

}}

class Mythread3 extends Thread{
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