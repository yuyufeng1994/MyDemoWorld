package proxy;

/**
 * 静态代理测试
 * 
 * @author Yu Yufeng
 *
 */
public class Test {
	public static void main(String[] args) {
		Subject subject = new RealSubject();
		Proxy proxy = new Proxy(subject);
		proxy.operate();
	}
}
/**
 * 运行结果：
 * before operate......
 * real subject operate started......
 * after operate......
 */
