package proxy;

import java.lang.reflect.Method;

/**
 * 动态代理类
 * 
 * @author Yu Yufeng
 *
 */
public class ProxyHandler {
	private Object proxied;

	public ProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	public String invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 在转调具体目标对象之前，可以执行一些功能处理
		System.out.println("before");
		// 转调具体目标对象的方法
		method.invoke(proxied, args);
		// 在转调具体目标对象之后，可以执行一些功能处理
		System.out.println("after");
		return this.toString();
	}
}
