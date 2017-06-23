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
    private String userContent;

    public String getUserContent() {
        return userContent;
    }

    public void setUserContent(String userContent) {
        this.userContent = userContent;
    }

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

    @Override
    public String toString() {
        return "TestBean{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", content='" + userContent + '\'' +
                '}';
    }
}
