package com.test.core.serivce.impl;

public class IpToNumber {
	public static void main(String[] args) {
		IpToNumber ipToNumber = new IpToNumber();
		System.out.println("IPV4的IP地址对应的整数为 : " + ipToNumber.ipToLong("192.168.199.1"));
	}
	
	public long ipToLong(String ipAddress) {
		long result = 0;
		String[] ipAddressInArray = ipAddress.split("\\.");
		//.1
		//开始写代码，将IPV4的IP地址转化为相对应的整数
		for (int i = 0; i < ipAddressInArray.length; i++) {

		    long ip = Long.parseLong(ipAddressInArray[3 - i]);  
		  
		    result |= ip << (i * 8);  
		}
		return result;
	}

}
