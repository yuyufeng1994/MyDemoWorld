package dao;

import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yuyufeng on 2017/4/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class UserDaoTest {
    @Autowired
    private  UserDao userDao;

    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("俞育峰");
        User res = userDao.save(user);
        System.out.println(res);
    }

    @Test
    public void test(){
        System.out.println("UserDaoTest.test");
    }
}
