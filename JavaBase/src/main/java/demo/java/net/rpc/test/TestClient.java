package demo.java.net.rpc.test;


import demo.java.net.rpc.HelloService;
import demo.java.net.rpc.RPCClient;

import java.net.InetSocketAddress;

/**
 * Created by yuyufeng on 2017/8/17.
 */
public class TestClient {
    public static void main(String[] args) {
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("127.0.0.1", 8088));
        System.out.println(service.sayHi("test"));
    }
}
