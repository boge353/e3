package com.e3.cart.utils.jedis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Service
public class JadisService implements JedisClient {
	@Autowired
	private ShardedJedisPool pool;
	//set方法无超时
	//set方法有超时
	//exists方法
	//get方法
	//del
	
	public void set(String key,String value){
		ShardedJedis jedis = pool.getResource();
		jedis.set(key, value);
		// redistemplate
		pool.returnResource(jedis);
	}
	public void set(String key,String value,Integer seconds){
		ShardedJedis jedis = pool.getResource();
		jedis.set(key, value);
		jedis.expire(key, seconds);
		pool.returnResource(jedis);
	}
	public Boolean exists(String key){
		ShardedJedis jedis = pool.getResource();
		Boolean exists = jedis.exists(key);
		pool.returnResource(jedis);
		return exists;
	}
	public String get(String key){
		ShardedJedis jedis = pool.getResource();
		String value = jedis.get(key);
		pool.returnResource(jedis);
		return value;
	}
	public void del(String key){
		ShardedJedis jedis = pool.getResource();
		jedis.del(key);
		pool.returnResource(jedis);
	}
	@Override
	public void expire(String key, int seconds) {
		ShardedJedis jedis = pool.getResource();
		jedis.expire(key, seconds);
		// redistemplate
		pool.returnResource(jedis);
	}
	@Override
	public Long ttl(String key) {
		ShardedJedis jedis = pool.getResource();
		Long ttlData= jedis.ttl(key);
		// redistemplate
		pool.returnResource(jedis);
		return ttlData;
	}
	@Override
	public Long incr(String key) {
		ShardedJedis jedis = pool.getResource();
		Long incrData= jedis.incr(key);
		// redistemplate
		pool.returnResource(jedis);
		return incrData;
	}
	@Override
	public void hset(String key, String field, String value) {
		ShardedJedis jedis = pool.getResource();
		jedis.hset(key, field, value);
		// redistemplate
		pool.returnResource(jedis);
	}
	@Override
	public String hget(String key, String field) {
		ShardedJedis jedis = pool.getResource();
		String value= jedis.hget(key, field);
		// redistemplate
		pool.returnResource(jedis);
		return value;
	}
	@Override
	public void hdel(String key, String... field) {
		ShardedJedis jedis = pool.getResource();
		jedis.hdel(key, field);
		// redistemplate
		pool.returnResource(jedis);
	}
	@Override
	public Boolean hexists(String key, String field) {
		ShardedJedis jedis = pool.getResource();
		Boolean hexists = jedis.hexists(key, field);
		pool.returnResource(jedis);
		return hexists;
	}
	@Override
	public List<String> hvals(String key) {
		ShardedJedis jedis = pool.getResource();
		List<String> value= jedis.hvals(key);
		// redistemplate
		pool.returnResource(jedis);
		return value;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
