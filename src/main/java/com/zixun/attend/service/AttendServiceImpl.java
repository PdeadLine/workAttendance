package com.zixun.attend.service;

import com.zixun.attend.dao.AttendMapper;
import com.zixun.attend.entity.Attend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by sintai_zx
 * 2018/7/2 13:17
 */
@Service("iAttendService")
public class AttendServiceImpl implements IAttendService {
    @Autowired
    AttendMapper attendMapper;

    /**
     @Author sintai_zx
     @Date 2018/7/2 15:08
     @Discreption 登记打卡信息
     */
    @Override
    public void signAttend(Attend attend) {
        attendMapper.insertSelective(attend);
    }

}
