package com.jarvis.springbootdemo.dao;

import com.jarvis.springbootdemo.bean.UserInfo;

public interface UserInfoDao {
    UserInfo getInfo(String name, String password);
}
