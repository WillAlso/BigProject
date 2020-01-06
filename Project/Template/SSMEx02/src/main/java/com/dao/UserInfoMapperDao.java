package com.dao;

import com.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapperDao {
    UserInfo selectOne(@Param("userId") Integer userId);
}
