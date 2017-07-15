package com.test.core.log;

import org.springframework.stereotype.Service;

@Service(value ="testService")
public class TestService {
	@Test
	public String test(String t ,int i){
		
		int is = 1;
		System.out.println(is);
		return "hao123yinLO";
	}
}
