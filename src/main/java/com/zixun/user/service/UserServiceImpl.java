package com.zixun.user.service;

import com.zixun.user.dao.UserMapper;
import com.zixun.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by sintai
 */
@Service("iUserService")
public class UserServiceImpl  implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public int createUser(User user,User user1) {
        userMapper.insertSelective(user);
        userMapper.insertSelective(user1);
        return 1;
    }
}
