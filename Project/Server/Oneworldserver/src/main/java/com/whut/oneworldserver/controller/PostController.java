package com.whut.oneworldserver.controller;

import com.google.gson.Gson;
import com.whut.oneworldserver.bean.PostCommentInfo;
import com.whut.oneworldserver.bean.PostInfo;
import com.whut.oneworldserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class PostController {

    /**
     * 客户端请求 ->
     * 服务器，服务器分发请求，Controller层 ->
     * 调用Service层服务 ->
     * Service层调用Dao层和数据库交互 ->
     * Dao层返回数据给Service，Service处理后，返回给Controller，然后Controller返回给View，即客户端
     */
    @Autowired
    PostService postService;

    @RequestMapping(value = "/getallpost",  produces = "application/json; charset=utf-8")
    public void getAllPost(HttpServletResponse response) {
        List<PostInfo> postInfos = postService.getAllPost();
        // java 7之后版本，使用try(){}，不用关闭“()”内的流
        try(PrintWriter printWriter = response.getWriter();) {
            // 转化为Json
            Gson gson = new Gson();
            String result = gson.toJson(postInfos);
            // 传送给客户端
            printWriter.print(result);
            // 刷新输出流
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/getpostcomment",  produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    public void getAllPostComment(@RequestParam("postNum") int postNum, HttpServletResponse response) {
        List<PostCommentInfo> commentInfos = postService.getPostComment(postNum);
        System.out.println(commentInfos);
        try (PrintWriter printWriter = response.getWriter();) {
            Gson gson = new Gson();
            String result = gson.toJson(commentInfos);
            printWriter.print(result);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
