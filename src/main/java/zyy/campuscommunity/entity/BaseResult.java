package zyy.campuscommunity.entity;

import lombok.ToString;

/**
 * 用来得到分页请求的结果
 * @author Zled
 * @date 2019/5/21 17:50
 */
@ToString
public class BaseResult {
   private long total;
   private Object data;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
