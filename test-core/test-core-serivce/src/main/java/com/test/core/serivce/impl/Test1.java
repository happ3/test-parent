package com.test.core.serivce.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test1 {
	public static void main(String[] args) {
		String url = "https://oapi.dingtalk.com/connect/qrconnect?appid=dingoaipb9gn5unu3cbnmk&response_type=code&scope=snsapi_login&state=123&redirect_uri=";
		
		try {
			url +=URLEncoder.encode("http://dm.devel.2dupay.com", "utf-8");
			System.out.println(url);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


//https://oapi.dingtalk.com/connect/qrconnect?appid=dingoaipb9gn5unu3cbnmk&response_type=code&scope=snsapi_login&state=123&redirect_uri=http://dm.devel.2dupay.com/login
//https://oapi.dingtalk.com/connect/qrconnect?appid=dingoaipb9gn5unu3cbnmk&response_type=code&scope=snsapi_login&state=123&redirect_uri=http%3A%2F%2Fdm..devel.2dupay.com
