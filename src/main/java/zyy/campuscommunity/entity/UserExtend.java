package zyy.campuscommunity.entity;

import lombok.ToString;

@ToString
public class UserExtend {

    private String userName;

    private String problem;

    public UserExtend() {
    }

    public UserExtend(String userName, String problem) {
        this.userName = userName;
        this.problem = problem;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
