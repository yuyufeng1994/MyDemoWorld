package service;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuyufeng on 2017/4/20.
 */
public interface UserService {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> queryAllUsers();
}
