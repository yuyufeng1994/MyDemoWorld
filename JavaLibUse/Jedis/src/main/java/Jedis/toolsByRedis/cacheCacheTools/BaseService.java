package Jedis.toolsByRedis.cacheCacheTools;

/**
 * 模拟服务
 * @author yuyufeng
 *
 */
public class BaseService {
	public String query(String req) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello:" + req;
	}
}
