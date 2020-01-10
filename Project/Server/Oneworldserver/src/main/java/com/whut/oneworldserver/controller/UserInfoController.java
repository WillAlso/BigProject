package com.whut.oneworldserver.controller;

import com.google.gson.Gson;
import com.whut.JSendSingleMailRequest;
import com.whut.oneworldserver.bean.SignInfo;
import com.whut.oneworldserver.bean.UserInfo;
import com.whut.oneworldserver.dao.UserInfoDao;
import com.whut.oneworldserver.service.UserInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@Controller
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/getuserforlogin", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    public void getUserForLogin(@RequestParam("param") String param, @RequestParam("passWord") String passWord, HttpServletResponse response) {
        UserInfo userInfo = userInfoService.getUserByPhone(param, passWord);
        if (userInfo == null) {
            userInfo = userInfoService.getUserByEmail(param, passWord);
            if (userInfo == null) {
                userInfo = userInfoService.getUserByUserId(param, passWord);
            }
        }
        try (PrintWriter printWriter = response.getWriter();) {
            Gson gson = new Gson();
            String result = gson.toJson(userInfo);
            printWriter.print(result);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/sendcode", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    public void sendCode(@RequestParam("email") String email, HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setMaxInactiveInterval(30);
        System.out.println(email);
        try (PrintWriter printWriter = response.getWriter();) {
            Random random = new Random();
            String code = String.format("%04d", random.nextInt(10000));
            String content = "One World用户：" + email + " 您好！您的验证码是：" + code + "，工作人员不会索要验证码，为了您的账户安全，请不要泄露给其他人！";
            JSendSingleMailRequest.getInstance().sendSingleTextMail(email, "One World验证码", "One World", content);
            request.getSession().setAttribute(email, code);
            printWriter.print(code);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/signuser", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    public void signUpUser(@RequestParam("msg") String msg, HttpServletRequest request, HttpServletResponse response) {
        SignInfo signInfo = new Gson().fromJson(msg, SignInfo.class);
        System.out.println(msg);
        UserInfo userInfo = signInfo.getUserInfo();
        try (PrintWriter printWriter = response.getWriter();) {
            userInfoService.insertUser(userInfo);
            printWriter.print("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
