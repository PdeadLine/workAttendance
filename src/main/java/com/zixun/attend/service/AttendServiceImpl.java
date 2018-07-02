package com.zixun.attend.service;

import com.zixun.attend.dao.AttendMapper;
import com.zixun.attend.entity.Attend;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * create by sintai_zx
 * 2018/7/2 13:17
 */
@Service("iAttendService")
public class AttendServiceImpl implements IAttendService {
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
           attendMapper.insertSelective(attend);
       }catch (Exception e){
        log.error("打卡异常",e);
        throw e;
       }

    }


}
