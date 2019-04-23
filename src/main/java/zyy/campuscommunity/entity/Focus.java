package zyy.campuscommunity.entity;

import lombok.ToString;

@ToString
public class Focus {
    private Integer id;

    private Integer userId;

    private String focusedId;

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

    public String getFocusedId() {
        return focusedId;
    }

    public void setFocusedId(String focusedId) {
        this.focusedId = focusedId == null ? null : focusedId.trim();
    }
}