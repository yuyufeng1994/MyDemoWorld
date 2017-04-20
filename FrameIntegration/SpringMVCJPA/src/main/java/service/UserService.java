package service;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuyufeng on 2017/4/20.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> queryAllUsers(){
        return (List<User>) userDao.findAll();
    }
}
