package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuyufeng on 2017/4/20.
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model model) {
        return "test";
    }
}
