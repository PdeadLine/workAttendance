package com.zixun.login.controller;

import com.zixun.common.utils.SecurityUtils;
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
    @RequestMapping("check")
    @ResponseBody
    public String checkLogin(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String userName = request.getParameter("username");
        String pwd = request.getParameter("password");

       User user= iUserService.findUserByUsername(userName);
        //todo 校验数据库账户,使用工具类md5加密明文密码与数据库比对
       if(user!=null&&SecurityUtils.checkMD5Password(pwd, user.getPassword())){
           //校验成功

           //todo 保存用户到session，进入首页
            user.setPassword("");
            request.getSession().setAttribute("user_info",user);
           // request.getRequestDispatcher("/home").forward(request,servletResponse);
           return "login_succ";
       }else {
           //校验失败
           return "login_fail";
       }



    }

   @RequestMapping("register")
   @ResponseBody
    public String registerUser(@RequestBody User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        iUserService.createUser(user);
        return "succ";

   }
}
