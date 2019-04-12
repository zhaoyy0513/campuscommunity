package zyy.campuscommunity.entity;

import lombok.ToString;

@ToString
public class Post {
    private Integer id;

    private String postUserName;

    private String postTitle;

    private Integer postTabId;

    private String postTabName;

    private Integer tabParentid;

    private String postContent;

    private String postTime;

    private String postContentImg;

    private String postUserIcon;

    private Integer postClickCount;

    private Integer postReplyCount;

    private String postLastReply;

    private String postLastReplyTime;

    private String postLastReplyTimeSimple;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostUserName() {
        return postUserName;
    }

    public void setPostUserName(String postUserName) {
        this.postUserName = postUserName == null ? null : postUserName.trim();
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle == null ? null : postTitle.trim();
    }

    public Integer getPostTabId() {
        return postTabId;
    }

    public void setPostTabId(Integer postTabId) {
        this.postTabId = postTabId;
    }

    public String getPostTabName() {
        return postTabName;
    }

    public void setPostTabName(String postTabName) {
        this.postTabName = postTabName == null ? null : postTabName.trim();
    }

    public Integer getTabParentid() {
        return tabParentid;
    }

    public void setTabParentid(Integer tabParentid) {
        this.tabParentid = tabParentid;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent == null ? null : postContent.trim();
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime == null ? null : postTime.trim();
    }

    public String getPostContentImg() {
        return postContentImg;
    }

    public void setPostContentImg(String postContentImg) {
        this.postContentImg = postContentImg == null ? null : postContentImg.trim();
    }

    public String getPostUserIcon() {
        return postUserIcon;
    }

    public void setPostUserIcon(String postUserIcon) {
        this.postUserIcon = postUserIcon == null ? null : postUserIcon.trim();
    }

    public Integer getPostClickCount() {
        return postClickCount;
    }

    public void setPostClickCount(Integer postClickCount) {
        this.postClickCount = postClickCount;
    }

    public Integer getPostReplyCount() {
        return postReplyCount;
    }

    public void setPostReplyCount(Integer postReplyCount) {
        this.postReplyCount = postReplyCount;
    }

    public String getPostLastReply() {
        return postLastReply;
    }

    public void setPostLastReply(String postLastReply) {
        this.postLastReply = postLastReply == null ? null : postLastReply.trim();
    }

    public String getPostLastReplyTime() {
        return postLastReplyTime;
    }

    public void setPostLastReplyTime(String postLastReplyTime) {
        this.postLastReplyTime = postLastReplyTime == null ? null : postLastReplyTime.trim();
    }

    public String getPostLastReplyTimeSimple() {
        return postLastReplyTimeSimple;
    }

    public void setPostLastReplyTimeSimple(String postLastReplyTimeSimple) {
        this.postLastReplyTimeSimple = postLastReplyTimeSimple == null ? null : postLastReplyTimeSimple.trim();
    }
}