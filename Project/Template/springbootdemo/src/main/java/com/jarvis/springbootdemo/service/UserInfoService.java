package com.jarvis.springbootdemo.service;

import com.jarvis.springbootdemo.bean.UserInfo;

public interface UserInfoService {
    UserInfo loginUser(String name, String password);
}
