package com.whut.oneworldserver.controller;

import com.google.gson.Gson;
import com.whut.oneworldserver.bean.ArticalInfo;
import com.whut.oneworldserver.service.SearchService;
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
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/getsearchartical",  produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public void getSearchArtical(@RequestParam("title") String title, HttpServletResponse response) {
        List<ArticalInfo> articalInfos = searchService.getSearchArtical(title);
        System.out.println(articalInfos);
        try (PrintWriter printWriter = response.getWriter();) {
            Gson gson = new Gson();
            String result = gson.toJson(articalInfos);
            printWriter.print(result);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
