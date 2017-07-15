package com.test.core.cache.config;

import org.nustaq.serialization.FSTConfiguration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * FTS 序列化
 * 
 *
 * @param <T>
 */
public class FSTSerializer<T> implements RedisSerializer<T> {

	static FSTConfiguration configuration = FSTConfiguration.createStructConfiguration();

	@Override
	public byte[] serialize(T t) throws SerializationException {
		if (t == null) {
			return null;
		}
		return configuration.asByteArray(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null) {
			return null;
		}
		return (T) configuration.asObject(bytes);
	}

}
