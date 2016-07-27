package com.bestpay.unioncashier.portal.web.controller.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5操作
 * Author: luwanchuan
 * Date: 2016/7/1
 */
@Slf4j
public class MD5 {

    /**
     * 使用ThreadLocal以空间换时间解决SimpleDateFormat线程安全问题
     */
    @SuppressWarnings("rawtypes")
    private static ThreadLocal threadLocal = new ThreadLocal() {
        protected synchronized Object initialValue() {
            MessageDigest messagedigest = null;
            try {
                messagedigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                log.error("初始化失败，MessageDigest不支持MD5", e);
            }
            return messagedigest;
        }
    };

    public static MessageDigest getMessageDigest() {
        return (MessageDigest) threadLocal.get();
    }

    public static String digest(String s, String charset) throws UnsupportedEncodingException {
        getMessageDigest().update(s.getBytes(charset));
        return HexUtil.bytes2Hexstr(getMessageDigest().digest());
    }

}
