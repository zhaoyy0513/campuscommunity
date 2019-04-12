package zyy.campuscommunity.entity;

import lombok.ToString;

@ToString
public class Tab {
    private Integer id;

    private String tabName;

    private Integer parentId;

    private String tabDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName == null ? null : tabName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTabDescribe() {
        return tabDescribe;
    }

    public void setTabDescribe(String tabDescribe) {
        this.tabDescribe = tabDescribe == null ? null : tabDescribe.trim();
    }
}