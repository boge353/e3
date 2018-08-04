package com.e3.cart.utils.jedis;

import java.util.List;

public interface JedisClient {

	void set(String key, String value);
	String get(String key);
	Boolean exists(String key);
	void expire(String key, int seconds);
	Long ttl(String key);
	Long incr(String key);
	void hset(String key, String field, String value);
	String hget(String key, String field);
	void hdel(String key, String... field);
	Boolean hexists(String key, String field);
	List<String> hvals(String key);
	void del(String key);
}
