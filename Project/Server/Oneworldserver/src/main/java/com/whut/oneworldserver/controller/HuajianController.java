package com.whut.oneworldserver.controller;

import com.google.gson.Gson;
import com.whut.oneworldserver.bean.ArticalInfo;
import com.whut.oneworldserver.service.HuajianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class HuajianController {
    @Autowired
    HuajianService huajianService;

    @RequestMapping(value = "/gethotartical", produces = "application/json; charset=utf-8")
    public void getHotArtical(HttpServletResponse response) {
        List<ArticalInfo> articalInfos = huajianService.getHotArtical();

        try (PrintWriter writer = response.getWriter();) {
            Gson gson = new Gson();
            String result = gson.toJson(articalInfos);
            writer.print(result);
            writer.flush();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
