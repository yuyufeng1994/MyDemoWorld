package service.impl;

import service.HelloService;

import java.util.UUID;

/**
 * Created by yuyufeng on 2017/6/21.
 */
public class HelloServiceImpl implements HelloService {
    private final  static String token = UUID.randomUUID().toString();//使每台机器有自己唯一的标识
    @Override
    public String say(String words) {
        System.out.println(token+" 执行say");
        return "say:" + words;
    }
}
