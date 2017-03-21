package proxy;

/**
 * 动态代理测试
 * 
 * @author Yu Yufeng
 *
 */
public class Test2 {

	public static void main(String[] args) throws Throwable {
		Subject subject = new RealSubject();
		ProxyHandler proxy = new ProxyHandler(subject);
		proxy.invoke(proxy, Subject.class.getMethod("operate"), new Object[] {});
	}

}
