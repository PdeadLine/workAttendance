package com.zixun.user.controller;

import com.zixun.user.entity.User;
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

    @RequestMapping("/index")
    public String user(){
        User user=new User();
        user.setUsername("张5");
        user.setPassword("123456");
        user.setMobile("1383838438");
        user.setRealName("资讯管理员");

        User user1=new User();
        user1.setId(3L);
        user1.setUsername("张4");
        user1.setPassword("123456");
        user1.setMobile("1383838438");
        user1.setRealName("资讯管理员");
        iUserService.createUser(user,user1);
        return "user";
    }


}
