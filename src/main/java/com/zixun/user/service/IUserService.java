package com.zixun.user.service;

import com.zixun.user.entity.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface IUserService {

    User findUserByUsername(String userName);

    void createUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
