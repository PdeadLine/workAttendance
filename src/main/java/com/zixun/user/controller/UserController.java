package com.zixun.user.controller;

import com.zixun.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
