package com.test.web.userinfo;

import org.springframework.util.Assert;

public class test {

	public static void main(String[] args) {
		String s = null;
    	Assert.notNull(s, "支付宝 修改信息不能为空");
    	System.out.println(s);
	}
}
