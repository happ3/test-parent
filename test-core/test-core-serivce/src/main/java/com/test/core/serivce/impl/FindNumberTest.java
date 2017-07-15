package com.test.core.serivce.impl;
public class FindNumberTest {
	public static void main(String[] args) {
		int number[] = new int[10001];
		int numCopy[] = new int[10001];
		int repeat = 0, notAppear = 0;
		int sumNumber = 0;
		int i;

		for (i = 0; i < 10001; i++) {//数组初始化
			number[i] = i;
		}
		number[573] = 5236;//设定重复数字5236出现两次，573不出现

		//No.1
		//开始写代码，仅遍历一次数组找出重复数和未出现的数字。 
		
			for (int o = 0; o < numCopy.length; o++) {
//				if(number[j] == numCopy[i]){
//					
//				}
			}
		
		//end_code
		System.out.println("重复数字："+repeat + " 未出现数字：" + notAppear);
	}
}
