package com.zixun.attend.service;

import com.zixun.attend.dao.AttendMapper;
import com.zixun.attend.entity.Attend;
import com.zixun.common.utils.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * create by sintai_zx
 * 2018/7/2 13:17
 */
@Service("iAttendService")
public class AttendServiceImpl implements IAttendService {
    /**
     * 中午12：00判定上下午
     */
    private static final int NOON_HOUR =12 ;
    private static final int NOON_MINUTE =00 ;
    @Autowired
    AttendMapper attendMapper;

    private Log log = LogFactory.getLog(AttendServiceImpl.class);

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     @Author sintai_zx
     @Date 2018/7/2 15:08
     @Discreption 登记打卡信息
     */
    @Override
    public void signAttend(Attend attend) throws Exception {
       try {
           Date today=new Date();
           attend.setAttendDate(today);
            attend.setAttendWeek((byte) DateUtils.getTodayWeek());
           //查询当天，此人有没有打卡记录
           Attend todayRecord=attendMapper.selectTodaySignRecord(attend.getUserId());

           Date noon = DateUtils.getDate(NOON_HOUR, NOON_MINUTE);
           if (today.compareTo(noon)<=0) {
            //打卡时间小于12点，上午打卡
               attend.setAttendMoring(today);
           }else {
               //下午打卡
               attend.setAttendEvening(today);
           }

   //打卡业务分析：1.中午十二点之前打卡，都算早晨打卡。如果8.30以后打开，直接异常，算迟到
           //2.十二点以后都算下午打卡；
           //3.下午打卡，检查与上午打卡时间差，17点之前算异常
           //4.不足八个小时都算异常，并且缺勤多长时间要保存进数据库

           attendMapper.insertSelective(attend);
       }catch (Exception e){
        log.error("打卡异常",e);
        throw e;
       }

    }


}
