package com.whut.oneworldserver.controller;

import com.google.gson.Gson;
import com.whut.oneworldserver.bean.ArticalInfo;
import com.whut.oneworldserver.service.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ArticalController {
    @Autowired
    ArticalService articalService;
    @RequestMapping(value = "/getallartical", produces = "application/json; charset=utf-8")
    public void getAllArtical(HttpServletResponse response) {
        List<ArticalInfo> articalInfos = articalService.getAllArtical();
        try(PrintWriter printWriter = response.getWriter();) {
            Gson gson = new Gson();
            String result = gson.toJson(articalInfos);
            printWriter.println(result);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
