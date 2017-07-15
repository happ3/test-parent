package com.test.core.serivce.impl;

import java.util.HashMap;
import java.util.Map;

public class ShangHaiBank {

	public static void main(String[] args) {
		
		Map<String,String> map =new HashMap<String,String>();
		map.put("pay_channel", "1");
		map.put("pay_method", "1");
		map.put("merchant_id", "1000001");
		map.put("sub_mch_trade_no", System.currentTimeMillis()+"");
		map.put("nonce_str", "1");
		map.put("body", "1");
		map.put("spbill_create_ip", "1");
		map.put("total_fee", "1");
		map.put("notify_url", "http://baidu.com");
		map.put("product_id", System.currentTimeMillis()+"");
		
		
		
		
	}
	
	
	
}
