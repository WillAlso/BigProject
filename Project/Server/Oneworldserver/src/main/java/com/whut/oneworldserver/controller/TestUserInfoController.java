package com.whut.oneworldserver.controller;

import com.google.gson.Gson;
import com.whut.oneworldserver.bean.TestUserInfo;
import com.whut.oneworldserver.service.TestUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class TestUserInfoController {
    @Autowired
    TestUserInfoService testUserInfoService;

    @RequestMapping("/testlogin")
    //http://127.0.0.1:8080/testlogin?username=will&password=123
    public void loginIn(String username, String password, HttpServletResponse response) {
        TestUserInfo testUserInfo = testUserInfoService.loginUser(username, password);
        try (PrintWriter printWriter = response.getWriter()) {
            Gson gson = new Gson();
            String result = gson.toJson(testUserInfo);
            printWriter.println(result);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
