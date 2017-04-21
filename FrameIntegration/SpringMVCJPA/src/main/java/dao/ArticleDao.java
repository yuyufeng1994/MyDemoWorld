package dao;

import entity.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yuyufeng on 2017/4/21.
 */
public interface ArticleDao extends PagingAndSortingRepository<Article, Long> {
}
