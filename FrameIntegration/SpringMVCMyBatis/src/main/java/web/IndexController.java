package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuyufeng on 2017/1/4.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("IndexController.index");
        return "main/index";
    }
}
