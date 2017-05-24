package org.apache.solr.bean;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by yuyufeng on 2017/5/24.
 */
public class TestBean {
    @Field
    private String id;
    @Field
    private String userName;
    @Field
    private int userScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userScore=" + userScore +
                '}';
    }
}
