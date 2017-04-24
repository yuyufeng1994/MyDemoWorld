package web;

import com.github.pagehelper.PageInfo;
import vo.JsonResult;
import entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import java.util.List;

/**
 * Created by yuyufeng on 2017/1/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list/{pageNo}")
    public String list(@PathVariable("pageNo") int pageNo,Model model){
        PageInfo<UserInfo> page = new PageInfo<UserInfo>();
        List<UserInfo> users = userService.getUserPage(pageNo,10);
        page.setList(users);
        model.addAttribute("page",page);
        return "user/list";
    }

    @RequestMapping("/list-json/{pageNo}")
    public @ResponseBody JsonResult<PageInfo<UserInfo>> listJson(@PathVariable("pageNo") int pageNo, Model model){
        PageInfo<UserInfo> page = new PageInfo<UserInfo>();
        List<UserInfo> users = userService.getUserPage(pageNo,10);
        page.setList(users);
        JsonResult<PageInfo<UserInfo>> jr = new JsonResult<PageInfo<UserInfo>>(true,page);
        return jr;
    }
}
