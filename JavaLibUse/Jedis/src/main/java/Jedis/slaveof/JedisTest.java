package Jedis.slaveof;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;

public class JedisTest {

	public static void main(String[] args) throws InterruptedException {
		 
		// Jedis jedis = new Jedis("192.168.21.129", 6379);
		// System.out.println(jedis.ping());
		HashSet<String> sentinels = new HashSet<String>();
		// 添加sentinel主机和端口
//		sentinels.add("192.168.21.129:26379");
//		sentinels.add("192.168.21.130:26379");
		sentinels.add("192.168.21.131:26379");
		JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels,"12345");
		
//		HostAndPort currentHostMaster = pool.getCurrentHostMaster();
//		System.out.println(currentHostMaster.getHost() + "--" + currentHostMaster.getPort());
//		Jedis jedis = pool.getResource();
//		System.out.println(jedis.ping());
//		jedis.close();
		
		int i = 0;
		while (true) {
			try {
				HostAndPort currentHostMaster = pool.getCurrentHostMaster();
				Jedis jedis = pool.getResource();
				System.out.println(i+++" "+currentHostMaster.getHost() + "--" + currentHostMaster.getPort()+" PING:"+jedis.ping());
				jedis.close();
			} catch (Exception e) {
				System.out.println("得不到jedis");
			}
//			Thread.sleep(100);
		}

	}

}
