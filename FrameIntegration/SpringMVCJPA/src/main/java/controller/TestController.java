package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import java.util.List;

/**
 * Created by yuyufeng on 2017/4/20.
 */
@Controller
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping("/test")
    public String test(Model model) {
        String message = messageSource.getMessage("ERR02", null, "未处理异常", null);
        System.out.println(message);

        return "test";
    }


    @RequestMapping("/test-json")
    public @ResponseBody
    List<User> testJson(){
       return  userService.queryAllUsers();
    }

}
