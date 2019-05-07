package zyy.campuscommunity.entity;

import lombok.ToString;

@ToString
public class Unread {
    private Integer id;

    private Integer userId;

    private String info;

    private Integer infocomeId;

    private String infocomeName;

    private String infocomeTime;

    private Integer postId;

    private String postTitle;

    private Integer replyId;

    public Unread() {
    }

    public Unread(Integer userId, String info, Integer infocomeId, String infocomeName, String infocomeTime, Integer postId, String postTitle, Integer replyId) {
        this.userId = userId;
        this.info = info;
        this.infocomeId = infocomeId;
        this.infocomeName = infocomeName;
        this.infocomeTime = infocomeTime;
        this.postId = postId;
        this.postTitle = postTitle;
        this.replyId = replyId;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getInfocomeId() {
        return infocomeId;
    }

    public void setInfocomeId(Integer infocomeId) {
        this.infocomeId = infocomeId;
    }

    public String getInfocomeName() {
        return infocomeName;
    }

    public void setInfocomeName(String infocomeName) {
        this.infocomeName = infocomeName == null ? null : infocomeName.trim();
    }

    public String getInfocomeTime() {
        return infocomeTime;
    }

    public void setInfocomeTime(String infocomeTime) {
        this.infocomeTime = infocomeTime == null ? null : infocomeTime.trim();
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle == null ? null : postTitle.trim();
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }
}