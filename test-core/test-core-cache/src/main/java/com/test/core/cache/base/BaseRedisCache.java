package com.test.core.cache.base;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

import com.test.core.cache.config.RedisCacheConfig;

import redis.clients.jedis.JedisPool;

/**
 * redis 模板 .
 * 
 * key 的命名规范为 object-type:id:field
 * 
 *
 */
public class BaseRedisCache {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected final static String USER_INFO = "userInfo:";
	protected final static String USER_INFO_USERNAME = "userInfo:username";

	
	
	@Resource(name = "redisCacheConfig")
	protected RedisCacheConfig redisCacheConfig;

	@Resource(name = "redisTemplate")
	protected RedisTemplate<String, Object> redisTemplate;

	@Resource(name = "redisTemplate")
	protected ValueOperations<String, Object> valueOperations;

	@Resource(name = "redisTemplate")
	protected ListOperations<String, Object> listOperations;

	@Resource(name = "redisTemplate")
	protected SetOperations<String, Object> setOperations;

	@Resource(name = "redisTemplate")
	protected ZSetOperations<String, Object> zSetOperations;

	@Resource(name = "redisTemplate")
	protected HashOperations<String, Object, Object> hashOperations;
	
	@Resource(name = "jedisPool")
	protected JedisPool jedisPool;
	
	

	/**
	 * 默认缓存超时时间单位为分钟
	 * 
	 * @param key
	 * @param value
	 */
	protected void set(String key, Object value) {
		this.set(key, value, redisCacheConfig.getBaseTimeout(), TimeUnit.MINUTES);
	}

	protected void set(String key, Object value, long timeout, TimeUnit unit) {
		if (key == null || value == null) {
			logger.warn("set redis cache key and value can't be empty! key: {} ,value :{}", key, value);
			return;
		}
		this.valueOperations.set(key, value, timeout, unit);
	}

	protected Object get(String key) {
		if (key == null) {
			logger.warn("get redis cache key  can't be empty! key: {} ", key);
			return null;
		}
		return this.valueOperations.get(key);
	}

	protected void del(String key) {
		if (key == null) {
			logger.warn("del redis cache key  can't be empty! key: {} ", key);
		}
		this.redisTemplate.delete(key);
	}

}
