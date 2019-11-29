package zyy.campuscommunity.entity;

import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@ToString
public class Tab implements  Serializable{
    private Integer id;

    private String tabName;

    private Integer parentId;

    private String tabDescribe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tab tab = (Tab) o;
        return Objects.equals(id, tab.id) &&
                Objects.equals(tabName, tab.tabName) &&
                Objects.equals(parentId, tab.parentId) &&
                Objects.equals(tabDescribe, tab.tabDescribe);
    }

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