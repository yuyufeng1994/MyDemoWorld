package Jedis.shardedjedis;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

public class SharedTest {

	public static void main(String[] args) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000);
		config.setTestOnBorrow(false);
		// slave链接
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
//		shards.add(new JedisShardInfo("192.168.21.129", 6379));
		shards.add(new JedisShardInfo("192.168.21.130", 6379));
		// 构造池
		ShardedJedisPool shardedJedisPool = new ShardedJedisPool(config, shards);
		shardedJedisPool.getResource().set("bbdas".getBytes(), "11".getBytes());
//		while (true) {
//			
//		}
		for(int i=0;i<100;i++){
			shardedJedisPool.getResource().set(("bbdas"+i).getBytes(), ("11"+i).getBytes());
		}
	}

}
