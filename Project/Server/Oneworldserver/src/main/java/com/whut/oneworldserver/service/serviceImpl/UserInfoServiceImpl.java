package com.whut.oneworldserver.service.serviceImpl;

import com.whut.oneworldserver.bean.UserInfo;
import com.whut.oneworldserver.dao.UserInfoDao;
import com.whut.oneworldserver.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserByPhoneExist(String phoneNum) {
        return userInfoDao.getUserByPhoneExist(phoneNum);
    }

    @Override
    public UserInfo getUserByUserIdExist(String userId) {
        return userInfoDao.getUserByUserIdExist(userId);
    }

    @Override
    public UserInfo getUserByEmailExist(String email) {
        return userInfoDao.getUserByEmailExist(email);
    }

    @Override
    public UserInfo getUserByPhone(String phoneNum, String passWord) {
        return userInfoDao.getUserByPhone(phoneNum, passWord);
    }

    @Override
    public UserInfo getUserByUserId(String userId, String passWord) {
        return userInfoDao.getUserByUserId(userId, passWord);
    }

    @Override
    public UserInfo getUserByEmail(String email, String passWord) {
        return userInfoDao.getUserByEmail(email, passWord);
    }

    @Override
    public void insertUser(UserInfo userInfo) {
        userInfoDao.insertUser(
                userInfo.getUserId(),
                userInfo.getUserName(),
                userInfo.getPassWord(),
                userInfo.getEmail(),
                userInfo.getPhoneNum(),
                userInfo.getSignature());
    }
}
