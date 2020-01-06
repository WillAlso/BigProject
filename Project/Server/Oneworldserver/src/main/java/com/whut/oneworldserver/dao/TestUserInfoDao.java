package com.whut.oneworldserver.dao;

import com.whut.oneworldserver.bean.TestUserInfo;

public interface TestUserInfoDao {
    TestUserInfo getInfo(String username, String password);
}
