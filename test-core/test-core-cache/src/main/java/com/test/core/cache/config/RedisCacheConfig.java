package com.test.core.cache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis 缓存配置
 * 
 *
 */
@Configuration
@Component(value = "redisCacheConfig")
@PropertySource(value = { "classpath:redis.properties" })
public class RedisCacheConfig {
	
	@Value(value = "${redis.cache.baseTimeout}")
	private int baseTimeout;
	
	@Value(value = "${redis.hostName}")
	private String host;
	
	@Value(value = "${redis.port}")
	private int port;
	
	@Value(value = "${redis.password}")
	private String password;
	
	
	

	/**
	 * RedisConnectionFactory
	 * 
	 * @param redisSentinelConfiguration
	 * @param jedisPoolConfig
	 * @return
	 */
	@Bean
	public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig,
			@Value("${redis.hostName}") String hostName, @Value("${redis.port}") int port,
			@Value("${redis.password}") String password) {
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
		redisConnectionFactory.setHostName(hostName);
		redisConnectionFactory.setPort(port);
		redisConnectionFactory.setPassword(password);
		redisConnectionFactory.afterPropertiesSet();
		
		return redisConnectionFactory;
	}
	
	/**
	 * JedisPool
	 * @param jedisPoolConfig
	 * @param hostName
	 * @param port
	 * @param password
	 * @param baseTimeout
	 * @return
	 */
	@Bean
	public JedisPool  jedisPool(JedisPoolConfig jedisPoolConfig,
			@Value("${redis.hostName}") String hostName, @Value("${redis.port}") int port,
			@Value("${redis.password}") String password,@Value("${redis.cache.baseTimeout}") int baseTimeout){
		JedisPool jedisPool = new  JedisPool(jedisPoolConfig, hostName, port, 100000);
		return jedisPool;
	}
	
	

	/**
	 * 连接池配置
	 * 
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "redis.pool")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		return jedisPoolConfig;
	}

	/**
	 * redisTemplate 配置 ，key 用 StringRedisSerializer 序列化 ， value 用 FSTSerializer
	 * 序列化
	 * 
	 * @param redisConnectionFactory
	 * @param jackson2JsonRedisSerializer
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new FSTSerializer<Object>());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
	
	public int getBaseTimeout() {
		return baseTimeout;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getPassword() {
		return password;
	}
	
	

	
}
