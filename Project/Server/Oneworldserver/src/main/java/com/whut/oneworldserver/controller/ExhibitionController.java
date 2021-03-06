package com.whut.oneworldserver.controller;

import com.google.gson.Gson;
import com.whut.oneworldserver.bean.ExhibitionCommentInfo;
import com.whut.oneworldserver.bean.ExhibitionInfo;
import com.whut.oneworldserver.service.ExhibitionService;
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
public class ExhibitionController {
    @Autowired
    ExhibitionService exhibitionService;
    @RequestMapping(value = "/getallexhibition", produces = "application/json; charset=utf-8")
    public void getAllExhibition(HttpServletResponse response) {
        List<ExhibitionInfo> exhibitionInfos = exhibitionService.getAllExhibition();
        try(PrintWriter printWriter = response.getWriter();) {
            Gson gson = new Gson();
            String result = gson.toJson(exhibitionInfos);
            printWriter.println(result);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/getexhibitioncomment", produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    public void getAllExhibitionComment(@RequestParam("exhibitionNum") int exhibitionNum, HttpServletResponse response) {
        List<ExhibitionCommentInfo> commentInfos = exhibitionService.getExhibitionComment(exhibitionNum);
        System.out.println(commentInfos);
        try(PrintWriter printWriter = response.getWriter();) {
            Gson gson = new Gson();
            String result = gson.toJson(commentInfos);
            printWriter.print(result);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
