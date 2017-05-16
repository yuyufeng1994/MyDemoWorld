package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuyufeng on 2017/5/10.
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("TestController.test");
        return "test/test";
    }
}
