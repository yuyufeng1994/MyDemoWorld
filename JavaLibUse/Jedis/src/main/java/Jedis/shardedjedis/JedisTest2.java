package Jedis.shardedjedis;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

public class JedisTest2 {
	public static void main(String[] args) throws InterruptedException {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000);
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		JedisShardInfo jss = new JedisShardInfo("192.168.21.129", 6379);
		JedisShardInfo jss2 = new JedisShardInfo("192.168.21.130", 6379);
		shards.add(jss);
		shards.add(jss2);
		ShardedJedisPool shardedJedisPool = new ShardedJedisPool(config, shards);
		// Jedis jedis = new Jedis("192.168.21.130",6379);
		for (int i = 0; i < 10000000; i++) {
			ShardedJedis shareJs = shardedJedisPool.getResource();
			System.out.println(i + " " + shareJs.set("k" + i, "v" + i));
			shareJs.close();
			Thread.sleep(200);
		}

	}
}
