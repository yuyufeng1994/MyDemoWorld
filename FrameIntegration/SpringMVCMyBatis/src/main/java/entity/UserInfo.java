package entity;

import java.util.Date;

public class UserInfo {
    private Long userId;

    private String userName;

    private Integer userRole;

    private Date createTime;

    public UserInfo(Long userId, String userName, Integer userRole, Date createTime) {
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userRole=" + userRole +
                ", createTime=" + createTime +
                '}';
    }
}