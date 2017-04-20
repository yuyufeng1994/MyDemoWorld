package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户实体
 * Created by yuyufeng on 2017/4/20.
 */
@Entity
@Table(name="user_info")
public class User implements Serializable {
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.AUTO) // 自动增长类型
    private Long userId;
    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
