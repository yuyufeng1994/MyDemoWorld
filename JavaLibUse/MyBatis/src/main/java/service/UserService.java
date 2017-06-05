package service;

import entity.UserInfo;
import mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yuyufeng on 2017/6/5.
 */
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Transactional
    public void add2User(){
        long time = System.currentTimeMillis();
        UserInfo user1 = new UserInfo();
        user1.setUserName("事务用户1:"+time);
        UserInfo user2 = new UserInfo();
        user2.setUserName("事务用户2:"+time);

        userInfoMapper.add(user1);
        //int i=10/0;
        userInfoMapper.add(user2);

        System.out.println("==========================");
        System.out.println(user1);
        System.out.println(user2);
        System.out.println("==========================");

    }
}
