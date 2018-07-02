package com.zixun.attend.controller;

import com.zixun.attend.entity.Attend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by sintai_zx
 * 2018/7/2 13:16
 */
@Controller
@RequestMapping("attend")
public class AttendController {

    public String toAttend() {
        return "attend";
    }

    public String signAttend(@RequestBody Attend attend) {

    }
}
