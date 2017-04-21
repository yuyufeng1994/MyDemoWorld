package dao;

import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public void testSaveList() {
        for (int i = 10; i < 50; i++) {
            User user = new User();
            user.setUserName("用户"+i);
            User res = userDao.save(user);
            System.out.println(res);
        }

    }

    @Test
    public void findAll() {
        List<User> list = (List<User>) userDao.findAll();
        for (User user : list) {
            System.out.println("##" + user);
        }
    }

    @Test
    public void testPage() {
        Sort sort = new Sort(Sort.Direction.DESC, "userId");
        Pageable pageable = new PageRequest(1, 10, sort);
        Page<User> page = userDao.findAll(pageable);
        for (User user : page.getContent()) {
            System.out.println(user);
        }
    }

    @Test
    public void test() {
        System.out.println("UserDaoTest.test");
    }
}
