package com.bestpay.unioncashier.portal.web.controller.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 签名验证
 * Author: luwanchuan
 * Date: 2016/7/1
 */
@Slf4j
public class SignValidateUtil {

    /**
     * 签名
     *
     * @param map    要排序的字符串
     * @param md5Key MD5的key值
     * @param keys   要排除的key值
     * @return
     * @throws Exception
     */
    public static String sign(Map<String, String> map, String md5Key, String... keys) throws Exception {
        return Digest.digest(map, md5Key, keys);
    }

    /**
     * 验证签名
     *
     * @param map    要排序的字符串
     * @param sign   签名值
     * @param md5Key MD5的key值
     * @param keys   要排除的key值
     * @return true 通过，false 不通过
     * @throws Exception
     */
    public static boolean validate(Map<String, String> map, String sign, String md5Key, String... keys) throws Exception {
        if (null == map || map.size() == 0 || null == sign || null == md5Key) {
            log.error("验证签名的参数不合法");
            return Boolean.FALSE;
        }
        // 签名
        String validateSign = Digest.digest(map, md5Key, keys);
        // 验证签名
        if (StringUtils.equals(validateSign, sign)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}
