package com.test.core.List;

import java.util.Hashtable;
import java.util.Set;

public class Hashtest {
	public static void main(String[] args) {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("a1", "a2");
		hashtable.put("b1", "b2");
		hashtable.put("c1", "c2");
		hashtable.put("d1", "d2");
		hashtable.put("e1", "e2");
		hashtable.put("f1", "f2");
		
		Set<String> keys = hashtable.keySet();
		for (String key : keys) {
			System.out.println(hashtable.get(key));
		}
	}
}
