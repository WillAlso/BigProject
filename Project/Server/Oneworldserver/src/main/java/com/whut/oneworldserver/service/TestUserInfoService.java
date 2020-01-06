package com.whut.oneworldserver.service;

import com.whut.oneworldserver.bean.TestUserInfo;

public interface TestUserInfoService {
    TestUserInfo loginUser(String username, String password);
}
