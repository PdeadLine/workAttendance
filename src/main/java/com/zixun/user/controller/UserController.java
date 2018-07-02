package com.zixun.user.controller;

import com.zixun.user.entity.User;
import com.zixun.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * create by sintai
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
        @Author sintai_zx
        @Date 2018/6/25 15:14
        @Discreption 跳转主页
    */
    @RequestMapping("/home")
    public String home() {
        return "home";
    }


    /**
        @Author sintai_zx
        @Date 2018/6/28 9:53
        @Discreption 获取登陆用户信息
    */
    @RequestMapping("/info")
    @ResponseBody
    public Object getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute("user_info");
        if (user!=null) {
            return user;
        }
        return "您没有登陆！";
    }
}
