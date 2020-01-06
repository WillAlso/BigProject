package com.jarvis.springbootdemo.controller;

import com.jarvis.springbootdemo.bean.UserInfo;
import com.jarvis.springbootdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String loginIn(String name, String password) {
        UserInfo userInfo = userInfoService.loginUser(name, password);
        if (userInfo != null) {
            return "success";
        } else {
            return "error";
        }
    }
}
