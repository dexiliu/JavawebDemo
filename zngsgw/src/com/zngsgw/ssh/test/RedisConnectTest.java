package com.zngsgw.ssh.test;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisConnectTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1");
		jedis.auth("root");//密码验证
		System.out.println("Server is running:"+jedis.ping());
		System.out.println(jedis.get("hello"));
		
		Set<String> list=jedis.keys("*");
		for(int i=0,n=list.size();i<n;i++){
			System.out.println(list.iterator().next());
		}
	}

}
