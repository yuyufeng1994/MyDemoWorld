package service.impl;

import com.github.pagehelper.PageHelper;
import dao.UserInfoMapper;
import entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

/**
 * Created by yuyufeng on 2017/1/4.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUserPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, "user_id");
        return userInfoMapper.selectList();
    }
}
