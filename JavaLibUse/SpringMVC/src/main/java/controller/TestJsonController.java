package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.JsonResult;

/**
 * Created by yuyufeng on 2017/5/16.
 */
@Controller
@RequestMapping("/json")
public class TestJsonController {

    @RequestMapping(value = "/get-data/{userId}",method = RequestMethod.GET)
    public @ResponseBody JsonResult<User> doGetData(@PathVariable("userId") Long userId){
        User user = new User(userId,"用户名1");
        JsonResult<User> jr = new JsonResult<User>(true,user);
        return jr;
    }

    @RequestMapping(value = "/post-data",method = RequestMethod.POST)
    public @ResponseBody JsonResult<User> doPostData(User user){
        JsonResult<User> jr = new JsonResult<User>(true,user);
        return jr;
    }
}
