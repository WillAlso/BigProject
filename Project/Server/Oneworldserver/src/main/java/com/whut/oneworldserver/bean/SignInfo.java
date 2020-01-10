package com.whut.oneworldserver.bean;

public class SignInfo {
    private String code;
    private UserInfo userInfo;

    public SignInfo(String code, UserInfo userInfo) {
        this.code = code;
        this.userInfo = userInfo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "SignInfo{" +
                "code='" + code + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
