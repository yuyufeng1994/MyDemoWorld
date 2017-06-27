package org.apache.solr.bean;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by yuyufeng on 2017/6/26.
 */
public class Post {
    @Field
    private Long postId;
    @Field
    private String postTitle;
    @Field
    private String postContent;
    @Field
    private String postTime;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }
}
