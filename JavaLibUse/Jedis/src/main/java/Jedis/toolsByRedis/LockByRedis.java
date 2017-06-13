package Jedis.toolsByRedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 借助redis的分布式锁
 * @author yuyufeng
 *
 */
public class LockByRedis {

	static int no = 0;
	static JedisPool jedisPool;
	static {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000);
		config.setTestOnBorrow(false);

		// 构造池
		jedisPool = new JedisPool(config, "127.0.0.1", 6379, 1000, "Bbkb_deve");
		Jedis jedis = jedisPool.getResource();
		jedis.flushAll();
		jedisPool.returnResource(jedis);
		

	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread() {
				@Override
				public void run() {
					for (int j = 0; j < 100; j++) {
						Jedis jedis = jedisPool.getResource();
						long incr = jedis.incr("lock-key");
						if (incr == 1) {
							System.out.println("### " + (++no));
							jedis.del("lock-key");
						} else {
							j--;
						}
						jedis.close();
					}

				}
			}.start();
		}
	}

}
