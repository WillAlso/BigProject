package com.service.impl;

import com.bean.UserInfo;
import com.dao.UserInfoMapperDao;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserInfoMapperDao userInfoMapperDao;

    @Override
    public UserInfo getUserInfoByUserId(Integer userId) {
        return userInfoMapperDao.selectOne(userId);
    }
}
