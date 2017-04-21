package dao;

import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by yuyufeng on 2017/4/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("用户5");
        User res = userDao.save(user);
        System.out.println(res);
    }

    @Test
    public void findAll() {
        List<User> list = (List<User>) userDao.findAll();
        for (User user : list) {
            System.out.println("##" + user);
        }
    }

    @Test
    public void test() {
        System.out.println("UserDaoTest.test");
    }
}
