package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserService userService;

    @RequestMapping("/test")
    public String test(Model model) {
        return "test";
    }


    @RequestMapping("/test-json")
    public @ResponseBody
    List<User> testJson(){
       return  userService.queryAllUsers();
    }

}
