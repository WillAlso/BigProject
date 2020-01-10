package com.whut.oneworldserver.service;


import com.whut.oneworldserver.bean.UserInfo;

public interface UserInfoService {

    UserInfo getUserByPhoneExist(String phoneNum);
    UserInfo getUserByUserIdExist(String userId);
    UserInfo getUserByEmailExist(String email);

    UserInfo getUserByPhone(String phoneNum, String passWord);
    UserInfo getUserByUserId(String userId, String passWord);
    UserInfo getUserByEmail(String email, String passWord);

    void insertUser(UserInfo userInfo);
}
