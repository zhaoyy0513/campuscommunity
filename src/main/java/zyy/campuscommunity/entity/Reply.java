package zyy.campuscommunity.entity;

import lombok.ToString;

@ToString
public class Reply {
    private Integer id;

    private Integer postId;

    private String replyUserName;

    private String replyContent;

    private String replyTime;

    private Integer replyFloor;

    private String replyTimeSimple;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName == null ? null : replyUserName.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime == null ? null : replyTime.trim();
    }

    public Integer getReplyFloor() {
        return replyFloor;
    }

    public void setReplyFloor(Integer replyFloor) {
        this.replyFloor = replyFloor;
    }

    public String getReplyTimeSimple() {
        return replyTimeSimple;
    }

    public void setReplyTimeSimple(String replyTimeSimple) {
        this.replyTimeSimple = replyTimeSimple == null ? null : replyTimeSimple.trim();
    }
}