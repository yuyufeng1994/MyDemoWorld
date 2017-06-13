package Jedis.push;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test {
	// 获取redis
	static JedisPool jedisPool;
	static {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000);
		config.setTestOnBorrow(false);

		// 构造池
		jedisPool = new JedisPool(config, "127.0.0.1", 6379, 1000, "Bbkb_deve");
	}

	public static void main(String[] args) {
		System.out.println(push());
		System.out.println(push());
	}

	public static String pop() {
		Jedis jedis = jedisPool.getResource();
		String res = jedis.lpop("queueKey");
		jedis.close();
		return res;
	}

	public static Long push() {
		Jedis jedis = jedisPool.getResource();
		Long res = jedis.lpush("queueKey", "aa123");
		jedis.close();
		return res;
	}

}
