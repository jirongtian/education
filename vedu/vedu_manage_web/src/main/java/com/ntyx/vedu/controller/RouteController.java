package com.ntyx.vedu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RouteController.class);

    @GetMapping(value = "/upload",name = "跳转upload页面")
    public String upload() {
        return "upload";
    }


    @GetMapping(value = "/multiUpload",name = "跳转多文件上传页面")
    public String multiUpload() {
        return "multiUpload";
    }


    
}


