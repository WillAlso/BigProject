package com.whut.oneworldserver.service.serviceImpl;

import com.whut.oneworldserver.bean.TestUserInfo;
import com.whut.oneworldserver.dao.TestUserInfoDao;
import com.whut.oneworldserver.service.TestUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class TestUserInfoServiceImpl implements TestUserInfoService {

    @Autowired
    private TestUserInfoDao testUserInfoDao;

    @Override
    public TestUserInfo loginUser(String username, String password) {
        return testUserInfoDao.getInfo(username, password);
    }
}
