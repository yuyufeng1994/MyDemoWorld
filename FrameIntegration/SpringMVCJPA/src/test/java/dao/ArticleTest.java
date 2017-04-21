package dao;

import entity.Article;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Created by yuyufeng on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class ArticleTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ArticleDao articleDao;



    @Test
    public void test(){
        System.out.println("ArticleTest.test");
    }

    @Test
    public void testFindOne(){
        User user = userDao.findOne(5l);
        System.out.println(user);
        Set<Article> sets= user.getArticles();
        for (Article set : sets) {
            System.out.println(set);
        }

    }

    @Test
    public void testSave(){
        User user = userDao.findOne(5l);
//        System.out.println(user);
        Article article = new Article();
        article.setArticleTitle("test标题2");
        article.setArticleContent("test内容2");
        article.setUser(user);
        Article res = articleDao.save(article);
        System.out.println(res);
    }


}
