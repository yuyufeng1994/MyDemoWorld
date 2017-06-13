package Jedis.toolsByRedis.cacheCacheTools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class CacheCacheToolTest {
	static long beginTime;
	static JedisPool jedisPool;
	static {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000);
		config.setTestOnBorrow(false);

		jedisPool = new JedisPool(config, "127.0.0.1", 6379, 1000, "Bbkb_deve");
		Jedis jedis = jedisPool.getResource();
		jedisPool.returnResource(jedis);

	}

	public static void main(String[] args) {
		beginTime = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			new Thread() {
				@Override
				public void run() {
					// 执行查询
						query();
					// System.out.println(System.currentTimeMillis()-beginTime);
				}
			}.start();

		}

	}

	public static void query() {
		BaseService bs = new BaseService();
		Jedis jedis = jedisPool.getResource();
		String req = "test123";
		String res;
		System.out.println(jedis.get(req));
		if (jedis.get(req) == null) {
			System.out.println("##查询接口服务");
			res = bs.query(req);
			jedis.setex(req, 100, res);
		} else {
			System.out.println("##查询缓存");
			res = jedis.get(req);
//			System.out.println("缓存剩余时间："+jedis.ttl(req));
			// 当时间超过10秒，异步更新数据到缓存
			if (jedis.ttl(req) < 90) {
				//模拟得到推送，接受推送，执行
				new Thread() {
					@Override
					public void run() {
						
						//保证5秒内，一条数据只更新一次
						Long incr = jedis.incr("incr-flag-"+req);
						jedis.expire("incr-flag-"+req, 5);
						
						if(1 == incr){
							String resT = bs.query(req);
							jedis.setex(req, 100, resT);
							System.out.println("异步更新数据："+req);
						}
					}
				}.start();

			}

		}
		jedisPool.returnResource(jedis);
	}

}
