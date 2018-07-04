package com.zixun.attend.service;

import com.zixun.attend.entity.Attend;
import com.zixun.common.utils.DateUtils;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * create by sintai_zx
 * 2018/7/4 14:05
 */

public class TestAttendance {


    public static   List<Attend> batchAddAttend() {
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long randomUid=0;
        long randomTime=0;
        int randomHour=0;
        int randomMinute=0;
        Date currTime=null;
        Date noon = DateUtils.getDate(12, 00);
        List<Attend> attendList = new ArrayList<Attend>();
        for (int i = 0; i <500 ; i++) {
            Attend attend= new Attend();
            attend.setAttendWeek((byte) DateUtils.getTodayWeek());
            attend.setAttendDate(new Date());
            //生成随机卡号
            randomUid= (long) (305100+Math.random()*99);
            attend.setUserId(randomUid);
            //生成随机时间
            randomTime=System.currentTimeMillis();
            Date today = new Date(randomTime);
            attend.setAttendDate(today);
            //随机打卡时间
            currTime = DateUtils.getDate((int)(Math.random() * 13), (int)(Math.random()*61));
            if (currTime.compareTo(noon) <= 0) {
                attend.setAttendMoring(currTime);
            }else {
                attend.setAttendEvening(currTime);
            }
            attendList.add(attend);
        }
             return attendList;
    }
}
