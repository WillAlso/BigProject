package com.test;

import com.bean.UserInfo;
import com.dao.UserInfoMapperDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserInfoMapperTest {
    @Autowired
    private UserInfoMapperDao userInfoMapperDao;

    @Test
    public void testSelectOne() {
        UserInfo userInfo = userInfoMapperDao.selectOne(1);
        System.out.println(userInfo);
    }
}
