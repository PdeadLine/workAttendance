package com.zixun.attend.controller;

import com.zixun.attend.entity.Attend;
import com.zixun.attend.service.IAttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by sintai_zx
 * 2018/7/2 13:16
 */
@Controller
@RequestMapping("attend")
public class AttendController {
    @Autowired
    private IAttendService iAttendService;

    public String toAttend() {
        return "attend";
    }

    @ResponseBody
    @RequestMapping("/sign")
    public String signAttend(@RequestBody Attend attend) throws Exception {
        iAttendService.signAttend(attend);
        return "succ";
    }
}
