package com.zixun.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping
    public String login(){
        return "login";
    }

    @RequestMapping("/check")
    public String checkLogin(HttpServletRequest request) {
        String username=request.getParameter("userNmae");
        String pwd=request.getParameter("pwd");
       //校验用户，使用md5校验
        //校验成功 保存session,
        //转发首页
        //校验失败 返回失败 single
        return "";

    }
}
