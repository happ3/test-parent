package com.test.core.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add("a");
		list.add("a1");
		list.add("a2");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("+++++++++++++++");
		for (Object object : list) {
			System.out.println(object);
			
		}
		System.out.println("==========");
		
		Iterator str = list.iterator();
		while(str.hasNext()){
			System.out.println(str.next());
		}
	
	
	}
}
