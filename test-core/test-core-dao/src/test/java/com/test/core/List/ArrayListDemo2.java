package com.test.core.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo2 {
	public static void main(String[] args) {
		
		ArrayList<Product> list = new ArrayList<Product>();
		Product product1 = new Product(1, "a1", 1, "b1");
		Product product2 = new Product(2, "a2", 1, "b2");
		Product product3 = new Product(3, "a3", 1, "b3");
		Product product4 = new Product(4, "a4", 1, "b4");
		list.add(product1);
		list.add(product2);
		list.add(product3);
		list.add(product4);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		
		}
		
		for (Product product : list) {
			System.out.println(product);
		}
		
		Iterator< Product> s = list.iterator();
		while(s.hasNext()){
			System.out.println(s.next());
		}
	}
}
