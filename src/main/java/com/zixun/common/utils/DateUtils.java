package com.zixun.common.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * create by sintai
 */
public class DateUtils {
   private static Calendar calendar = Calendar.getInstance();


    /**
         * @Author pdeadline [sintaiZX]
         * @Date    2018/7/2 23:43
         * @Description 获取当天是星期几
         *
         */
    public static int getTodayWeek() {
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
        int minute=(int)(end - start) / (1000 * 60);
        return minute;
    }

    /**
        @Author sintai_zx
        @Date 2018/7/3 14:07
        @Discreption 转换成时间格式
    */
    public static Date getDate(int hour, int minute) {
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        return calendar.getTime();
    }
}
