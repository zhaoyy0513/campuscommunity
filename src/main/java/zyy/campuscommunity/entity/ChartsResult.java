package zyy.campuscommunity.entity;

import java.util.List;

/**
 * @author Zled
 * @date 2019/6/5 20:29
 */
public class ChartsResult {
  private Object listData;
  private Object keys;
  private String values;
  private String currentTime;

    public ChartsResult() {
    }

    public ChartsResult(Object listData, Object keys, String values, String currentTime) {
        this.listData = listData;
        this.keys = keys;
        this.values = values;
        this.currentTime = currentTime;
    }

    public Object getListData() {
        return listData;
    }

    public void setListData(Object listData) {
        this.listData = listData;
    }

    public Object getKeys() {
        return keys;
    }

    public void setKeys(Object keys) {
        this.keys = keys;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
