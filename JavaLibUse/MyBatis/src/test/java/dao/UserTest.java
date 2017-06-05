package dao;

import entity.UserInfo;
import mapper.UserInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by yuyufeng on 2017/6/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserTest {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    public void test(){

    }
    @Test
    public void testSelectList(){
        List<UserInfo> list =  userInfoMapper.selectList();
        for (UserInfo userInfo : list) {
            System.out.println(userInfo);
        }
    }

    @Test
    public void testAdd(){
        UserInfo user = new UserInfo();
        user.setUserName("用户"+new Date().getTime());
//        UserInfo userResult =
        userInfoMapper.add(user);
        System.out.println(user);
//        System.out.println(userResult);
    }
}
