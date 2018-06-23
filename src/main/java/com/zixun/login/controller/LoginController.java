package com.zixun.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * create by sintai
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping
    public String showLogin() {
        return "login";
    }

    @RequestMapping("check")
    public String checkLogin(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String pwd = request.getParameter("password");
        //todo 校验数据库账户,使用工具类md5加密明文密码与数据库比对
        //todo 保存用户到session，进入首页
    }


}
