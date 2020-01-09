package com.whut.oneworldserver.dao;

import com.whut.oneworldserver.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoDao {

    UserInfo getUserByPhoneExist(@Param("phoneNum") String phoneNum);

    UserInfo getUserByUserIdExist(@Param("userId") String userId);

    UserInfo getUserByEmailExist(@Param("email") String email);

    UserInfo getUserByPhone(@Param("phoneNum") String phoneNum, @Param("passWord") String passWord);

    UserInfo getUserByUserId(@Param("userId") String userId, @Param("passWord") String passWord);

    UserInfo getUserByEmail(@Param("email") String email, @Param("passWord") String passWord);

    void insertUser(
            @Param("userId") String userId,
            @Param("userName") String userName,
            @Param("passWord") String passWord,
            @Param("email") String email,
            @Param("phoneNum") String phoneNum,
            @Param("signature") String signature
    );
}
