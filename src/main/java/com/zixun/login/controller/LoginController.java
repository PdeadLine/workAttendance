package com.zixun.login.controller;

import com.zixun.user.entity.User;
import com.zixun.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * create by sintai
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private IUserService iUserService;

    /**
         * @Author pdeadline [sintaiZX]
         * @Date    2018/6/24 21:36
         * @Description 登陆页面
         *
         */
    @RequestMapping
    public String showLogin() {
        return "login";
    }

    /**
         * @Author pdeadline [sintaiZX]
         * @Date    2018/6/24 21:36
         * @Description 校验登陆
         *
         */
    @ResponseBody
    @RequestMapping("check")
    public String checkLogin(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String pwd = request.getParameter("password");

       User user= iUserService.findUserByUsername(userName);
        //todo 校验数据库账户,使用工具类md5加密明文密码与数据库比对
        //todo 保存用户到session，进入首页
        return "login_succ";
    }

   @RequestMapping("register")
   @ResponseBody
    public String registerUser(@RequestBody User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        iUserService.createUser(user);
        return "succ";
    }
}
