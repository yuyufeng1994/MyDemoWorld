package service.Impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

/**
 * Created by yuyufeng on 2017/4/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Page<User> findPage() {
        Sort sort = new Sort(Sort.Direction.ASC,"userId");
        Pageable pageable = new PageRequest(0,100,sort);
        return userDao.findAll(pageable);
    }
}
