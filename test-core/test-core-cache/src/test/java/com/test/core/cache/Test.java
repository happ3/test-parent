package com.test.core.cache;

import redis.clients.jedis.Jedis;

public class Test {
	 public static void main(String[] args) {
	      //连接本地的 Redis 服务
	      Jedis jedis = new Jedis("192.168.0.250");
	      System.out.println("Connection to server sucessfully");
	      //查看服务是否运行
	      System.out.println("Server is running: "+jedis.ping());
	 }
}
