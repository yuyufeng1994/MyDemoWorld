package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import service.UserService;

/**
 * Created by yuyufeng on 2017/4/22.
 */
@Namespace("/user")
@ParentPackage("struts-default")
@Controller
public class UserAction extends ActionSupport implements ModelDriven<User> {
    protected static final int DEFAULT_PAGE_NUM = 0;
    protected static final int DEFAULT_PAGE_SIZE = 5;
    private User model = new User();
    @Autowired
    private UserService userService;

    public void setModel(User model) {
        this.model = model;
    }

    private static final long serialVersionUID = 1L;

    protected Integer pageNum;


    public Integer getPageNum() {
        return pageNum;
    }
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public User getModel() {
        return model;
    }

    /**
     * 用户列表页面
     */
    @Override
    @Action(value = "user-list", results = {
            @Result(name = "success", type = "dispatcher", location = "/WEB-INF/content/user/user-list.jsp") })
    public String execute() throws Exception {

        if(pageNum == null){
            pageNum = DEFAULT_PAGE_NUM;
        }

        Page<User> page = userService.findPage();

        ActionContext.getContext().put("page", page);
        return SUCCESS;
    }


}
