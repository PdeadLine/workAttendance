package com.zixun.user.service;

import com.zixun.common.utils.SecurityUtils;
import com.zixun.user.dao.UserMapper;
import com.zixun.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
        int a=1/0;
        userMapper.insertSelective(user1);
        return 0;
    }

    /**
         * @Author pdeadline [sintaiZX]
         * @Date    2018/6/24 21:35
         * @Description 根据用户名查询用户
         *
         */
    @Override
    public User findUserByUsername(String userName) {
            User user=userMapper.selectByUserName(userName);
            return user;

    }

    /**
         * @Author pdeadline [sintaiZX]
         * @Date    2018/6/24 21:46
         * @Description 内部使用：创建测试用户
         *
         */
    @Override
    public void createUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        user.setPassword(SecurityUtils.encrptyPassword(user.getPassword()));
        userMapper.insertSelective(user);
    }
}
