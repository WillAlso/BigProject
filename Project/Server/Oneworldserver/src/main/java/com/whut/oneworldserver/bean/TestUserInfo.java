package com.whut.oneworldserver.bean;

public class TestUserInfo {
    private int userid;
    private String username;
    private String password;

    public TestUserInfo() {
    }

    public TestUserInfo(int userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestUserInfo{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}