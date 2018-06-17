package com.zixun.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by sintai
 */
@Controller
@RequestMapping("user")
public class UserController {


    public String user(){
        return "user";
    }
}
