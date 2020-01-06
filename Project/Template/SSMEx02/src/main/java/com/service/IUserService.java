package com.service;

import com.bean.UserInfo;

public interface IUserService {
    UserInfo getUserInfoByUserId(Integer userId);
}
