package zyy.campuscommunity.entity;

/**
 * @author Zled
 * @date 2019/6/5 19:15
 */
public class ChartData {
    private Object value;
    private String name;

    public ChartData() {
    }

    public ChartData(Object value, String name) {
        this.value = value;
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
