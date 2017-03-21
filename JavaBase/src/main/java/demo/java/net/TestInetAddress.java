package demo.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

//网络通信的第一个要素：IP地址
//1.InetAddress用来代表IP地址
//2.如何创建InetAddress对象 InetAddress.getByName("www.baidu.com");
//3.getHostName/getHostAddress
public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet  = InetAddress.getByName("www.baidu.com");
		System.out.println(inet);
		System.out.println(inet.getHostName());
		System.out.println(inet.getHostAddress());
		
		
		InetAddress inet1  = InetAddress.getLocalHost();
		System.out.println(inet1);
	}
}
