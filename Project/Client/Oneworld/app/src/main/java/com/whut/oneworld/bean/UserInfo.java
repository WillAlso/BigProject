package com.whut.oneworld.bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class UserInfo {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "serialNum")
    private int serialNum;
    @ColumnInfo(name = "userId")
    private String userId;
    @ColumnInfo(name = "userName")
    private String userName;
    @ColumnInfo(name = "passWord")
    private String passWord;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "phoneNum")
    private String phoneNum;
    @ColumnInfo(name = "signature")
    private String signature;

    public UserInfo() {
    }

    public UserInfo(int serialNum, String userId, String userName, String passWord, String email, String phoneNum, String signature) {
        this.serialNum = serialNum;
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phoneNum = phoneNum;
        this.signature = signature;
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
                '}';
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
}
