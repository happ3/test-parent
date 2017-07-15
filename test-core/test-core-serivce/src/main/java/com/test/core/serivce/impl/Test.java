package com.test.core.serivce.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;

public class Test {

	public static void main(String[] args) {
//		String str = "bank_no=&bfb_order_create_time=20170531165439&bfb_order_no=2017053190001000051112822619659&buyer_sp_username=&currency=1&extra=&fee_amount=0&input_charset=1&order_no=P191075937259880320&pay_result=1&pay_time=20170531170124&pay_type=2&sign_method=1&sp_no=9000100005&total_amount=1&transport_amount=0&unit_amount=1&unit_count=1&version=2&sign=8f4039066894841ef7989830dc8daf6f";
//		String param = str.substring(0,str.lastIndexOf("&"));
//		System.out.println(param);
//		BigInteger bi = new BigInteger("191720320900530048");
//		System.out.println(bi.toString(36));
		
		String d = "P191720320900530048";
		System.out.println(d.hashCode());
//		d = d.substring(1);
//		BigInteger bi = new BigInteger(d);
//		System.out.println(bi.toString(36));
//		BigInteger i = new BigInteger("1gfr6jj46hs0", 36);
//		System.out.println(i);
	}
	
	//MD5签名算法
			public final static String md5Digest(String res) {
				if(res ==null||"".equals(res)){
					return null;
				}
				char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
				byte[] strTemp;
				try {
					strTemp = res.getBytes("gbk");
				} catch (UnsupportedEncodingException e1) {
					return null;
				}
				try {
					MessageDigest mdTemp = MessageDigest.getInstance("MD5");
					mdTemp.update(strTemp);
					byte[] md = mdTemp.digest();
					int j = md.length;
					char str[] = new char[j * 2];
					int k = 0;
					for (int i = 0; i < j; i++) {
						byte byte0 = md[i];
						str[k++] = hexDigits[byte0 >>> 4 & 0xf];
						str[k++] = hexDigits[byte0 & 0xf];
					}
					String dd = new String(str);
					return dd;
				} catch (Exception e) {
					return null;
				}
			}
}
