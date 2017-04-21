package entity;

import javax.persistence.*;

/**
 * 角色实体
 * Created by yuyufeng on 2017/4/21.
 */
@Entity
@Table(name="article_info")
public class Article {
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.AUTO) // 自动增长类型
    private  Long articleId;
    private String articleTitle;
    private String articleContent;

    @ManyToOne(cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "user_id")
    private User user;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", user=" + user +
                '}';
    }
}
