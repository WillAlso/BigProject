package com.controller;

import com.bean.UserInfo;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/user")
    private void toUser(Integer userId, HttpServletResponse response) {
        System.out.println("Hello user");
        UserInfo userInfo = userService.getUserInfoByUserId(userId);
        try(PrintWriter writer = response.getWriter();) {
            writer.println(userInfo);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
