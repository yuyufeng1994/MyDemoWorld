package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Spring data jpa native sql test
 * Created by yuyufeng on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class NativeSqlTest {
    @PersistenceContext//(unitName="")
    private EntityManager em;

    @Test
    public void test() {
        System.out.println("NativeSqlTest.test");
    }

    @Test
    public void testEm() {
        Query query = em.createNativeQuery("SELECT articleTitle,articleContent FROM  article_info where articleId = 1");
        Object[] obj = (Object[]) query.getSingleResult();
        System.out.println(obj[0]);
        System.out.println(obj[1]);
    }
}
