package com.jarvis.springbootdemo;

import com.jarvis.springbootdemo.bean.UserInfo;
import com.jarvis.springbootdemo.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootdemoApplicationTests {

    @Autowired
    UserInfoService userInfoService;

    @Test
    void contextLoads() {
        UserInfo userInfo = userInfoService.loginUser("a", "a");
        System.out.println("Userid ");
        System.out.println(userInfo.getId());
    }

}
