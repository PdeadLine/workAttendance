package com.zixun.common.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * create by sintai
 */
public class DateUtils {



    /**
         * @Author pdeadline [sintaiZX]
         * @Date    2018/7/2 23:43
         * @Description 获取当天是星期几
         *
         */
    public static int getTodayWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int week=calendar.get(Calendar.DAY_OF_WEEK);
        return week<0?7:week;
    }

    /**
         * @Author pdeadline [sintaiZX]
         * @Date    2018/7/2 23:42
         * @Description 计算两个时间差（分钟
         *
         */
    public static int getMunite(Date startDate,Date endDate) {
        long start=startDate.getTime();
        long end=endDate.getTime();
        int munite=(int)(end - start) / (1000 * 60);
        return munite;
    }

}
