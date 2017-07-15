package com.test.core.cache;


import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Test4 {
	 public static void main(String[] args) {
	      //连接本地的 Redis 服务
	      Jedis jedis = new Jedis("192.168.0.250");
	      System.out.println("Connection to server sucessfully");
	      
	     // 获取数据并输出
	     Set<String> set  = jedis.keys("*");
	     for (String str : set) {  
	         System.out.println(str);  
	     } 
	   }
}
