package com.zixun.common.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * create by sintai
 */
public class SecurityUtils {

    /**
     * MD5加密
     * @param password
     * @return
     */
    public String encrptyPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //消息摘要
        MessageDigest md5=MessageDigest.getInstance("MD5");
        //防止乱码
        BASE64Encoder base64Encoder=new BASE64Encoder();
       String result= base64Encoder.encode(md5.digest(password.getBytes("utf-8")));
        return result;
    }

    public boolean checkPassword(String inputPwd, String dbPwd) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String result = encrptyPassword(inputPwd);
        if (result.equals(dbPwd)) {
            return true;
        }
        return false;
    }
}
