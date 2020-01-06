package com.jarvis.springbootdemo.serviceImpl;

import com.jarvis.springbootdemo.bean.UserInfo;
import com.jarvis.springbootdemo.dao.UserInfoDao;
import com.jarvis.springbootdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo loginUser(String name, String password) {
        return userInfoDao.getInfo(name, password);
    }
}
