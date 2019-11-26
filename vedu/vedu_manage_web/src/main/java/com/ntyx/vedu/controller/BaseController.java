package com.ntyx.vedu.controller;


import com.ntyx.vedu.entity.User;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {
    public HttpServletRequest request;
    public HttpServletResponse response;
    public HttpSession session;
    public String companyId;
    public String companyName;
    public User loginUser;
    //提前先将数据抽取 request 公共对象
    @ModelAttribute //在执行当前的所有方法之前 优先执行
    public void before(HttpServletRequest request, HttpServletResponse response , HttpSession session){
        this.request = request;
        this.response = response;
        this.session = session;
        User loginUser = (User)session.getAttribute("loginUser");
        if(loginUser != null){
            this.loginUser = loginUser;
            companyId = loginUser.getCompanyId();
            companyName= loginUser.getCompanyName();
        }
    }
}
