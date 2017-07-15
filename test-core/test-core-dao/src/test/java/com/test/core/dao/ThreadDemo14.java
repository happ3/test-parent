package com.test.core.dao;

import java.util.Random;

public class ThreadDemo14 {
	public static void main(String[] args) {
		WiteSend witeSend = new WiteSend();
		WaitRec waitRec = new WaitRec(witeSend);
		
		Thread t1 =new Thread(witeSend);
		Thread t2 =new Thread(waitRec);
		t1.start();
		t2.start();
		
	}
}


class WiteSend implements Runnable{
	boolean flag;
	int theValue;
	
	@Override
	public void run() {
			for (int i = 1; i <= 5; i++) {
				System.out.println("i=  "+i);
				synchronized (this) {
					while (flag) {//why需要用while 存在中断和虚假唤醒
						try {
							this.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//生产者生产食物
					theValue = new Random().nextInt(1000);
					System.out.println("send value "+ theValue);
					//自己去等待
					flag =true;
					//唤醒消费者
					this.notify();
			}
		}
	}
}


class WaitRec implements Runnable{
	private WiteSend send;

	public WaitRec(WiteSend send) {
		super();
		this.send = send;
	}

	@Override
	public void run() {
		//不知道生产多少,生产多少消费多少
		while (true) {
			synchronized (send) {
				while (!send.flag) {
					try {
						send.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//消费食物
				System.out.println("recevie value "+ send.theValue);
				
				send.flag=false;
				//
				send.notify();
			}
		}
	}
}



