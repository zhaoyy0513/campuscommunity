package zyy.campuscommunity.entity;

import lombok.ToString;

@ToString
public class Unread {
    private Integer id;

    private String userId;

    private String info;

    private String infocomeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getInfocomeId() {
        return infocomeId;
    }

    public void setInfocomeId(String infocomeId) {
        this.infocomeId = infocomeId == null ? null : infocomeId.trim();
    }
}