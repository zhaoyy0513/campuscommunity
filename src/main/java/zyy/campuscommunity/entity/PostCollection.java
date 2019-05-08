package zyy.campuscommunity.entity;

import lombok.ToString;

@ToString
public class PostCollection {
    private Integer id;

    private Integer userId;

    private String postId;

    public PostCollection() {
    }

    public PostCollection(Integer userId, String postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }
}