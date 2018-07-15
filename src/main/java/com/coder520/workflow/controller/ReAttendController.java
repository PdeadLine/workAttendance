package com.coder520.workflow.controller;/**
 * Created by wangjianbin on 2017/6/28.
 */

import com.coder520.user.entity.User;
import com.coder520.workflow.entity.ReAttend;
import com.coder520.workflow.service.ReAttendService;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 补签工作流控制器
 *
 * @author wangjianbin
 * @create 2017-06-28 17:21
 **/
@Controller
@RequestMapping("reAttend")
public class ReAttendController {

    @Autowired
    private ReAttendService reAttendService;

    /**
         * @Author pdeadline [sintaiZX]
         * @Date    2018/7/10 22:29
         * @Description 补签记录
         *
         */
    @RequestMapping
    public String toReAttend(Model model,HttpSession session){

        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("userinfo");
        List<ReAttend> reAttendList = reAttendService.listReAttend(user.getUsername());
        model.addAttribute("reAttendList",reAttendList);
        return "reAttend";
    }


    /**
         * @Author pdeadline [sintaiZX]
         * @Date    2018/7/10 22:25
         * @Description 申请补签
         *
         */
    @RequestMapping("/start")
    public void startReAttendFlow(@RequestBody ReAttend reAttend, HttpSession session){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("userinfo");
        reAttend.setReAttendStarter(user.getRealName());
        reAttendService.startReAttendFlow(reAttend);
    }

    /**
         * @Author pdeadline [sintaiZX]
         * @Date    2018/7/10 22:28
         * @Description 待办补签
         *
         */
//    @RequiresRoles("leader")
    @RequiresPermissions("reAttend:list")
    @RequestMapping("/list")
    public String listReAttendFlow(Model model,HttpSession session){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("userinfo");
        String userName = user.getUsername();
        List<ReAttend> tasks = reAttendService.listTasks(userName);
        model.addAttribute("tasks",tasks);
        return  "reAttendApprove";
    }

    /**
         * @Author pdeadline [sintaiZX]
         * @Date    2018/7/10 22:26
         * @Description 审核补签
         *
         */
    @RequestMapping("/approve")
    public void approveReAttendFlow(@RequestBody ReAttend reAttend){
        reAttendService.approve(reAttend);
    }

}
