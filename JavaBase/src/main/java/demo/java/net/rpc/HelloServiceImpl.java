package demo.java.net.rpc;

/**
 * Created by yuyufeng on 2017/8/17.
 */
public class HelloServiceImpl implements HelloService {

    public String sayHi(String name) {
        return "Hi, " + name;
    }

}