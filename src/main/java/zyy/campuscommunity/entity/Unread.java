package zyy.campuscommunity.entity;

import lombok.ToString;

@ToString
public class Unread {
    private Integer id;
    private Integer userId;
    private String info;
    private Integer infocomeId;
    public Unread() {
    }
    public Unread(Integer userId, String info, Integer infocomeId) {
        this.userId = userId;
        this.info = info;
        this.infocomeId = infocomeId;
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
}