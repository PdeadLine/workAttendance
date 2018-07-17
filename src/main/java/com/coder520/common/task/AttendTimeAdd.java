package com.coder520.common.task;

import com.coder520.attend.entity.Attend;
import com.coder520.attend.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by sintai_zx
 * 2018/7/10 14:28
 */
public class AttendTimeAdd {
    @Autowired
    private AttendService attendService;
    private Attend attend=new Attend();
    private int count=0;
    /**
        @Author sintai_zx
        @Date 2018/7/10 14:29
        @Discreption 测试定时器-每十分钟打一次卡
    */
    public void loopAddAttend() throws Exception {
        System.out.print("第一个任务:");
        System.out.print(count++);
        System.out.print(":次");
    }
}
