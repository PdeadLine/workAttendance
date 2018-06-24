package com.zixun.common.utils;


import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecrityUtils {


    public String encrptPasswordMD5(String inputPwd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder=new BASE64Encoder();
        String result=base64Encoder.encode(md5.digest(inputPwd.getBytes("utf-8")));
        return result;
    }

    public boolean checkPassword(String inputPwd, String dbPwd) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String result =encrptPasswordMD5(inputPwd);
        if (result.equals(dbPwd)) {
            return true;
        }
        return false;
    }
}
