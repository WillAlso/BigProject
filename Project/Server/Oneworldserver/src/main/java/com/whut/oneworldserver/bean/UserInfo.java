package com.whut.oneworldserver.bean;

public class UserInfo {
    private int serialNum;
    private String userId;
    private String userName;
    private String passWord;
    private String email;
    private String phoneNum;
    private String signature;
    private String imageUrl;

    public UserInfo() {
    }

    public UserInfo(int serialNum, String userId, String userName, String passWord, String email, String phoneNum, String signature, String imageUrl) {
        this.serialNum = serialNum;
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phoneNum = phoneNum;
        this.signature = signature;
        this.imageUrl = imageUrl;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "serialNum=" + serialNum +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", signature='" + signature + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
