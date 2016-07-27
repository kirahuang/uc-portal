package com.bestpay.unioncashier.portal.web.controller.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 数据摘要，对传来的数据进行Md5数据摘要
 * Author: luwanchuan
 * Date: 2016/7/1
 */
@Slf4j
public class Digest {

    /**
     * 直接对传来的字符串进行md5摘要
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String digest(String str) {
        String md5 = null;
        try {
            log.debug("生成的字符串为:{}", str);
            md5 = MD5.digest(str, CodecConstants.UTF_8);
            log.debug("生成的Md5摘要为:{}", md5);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return md5;
    }

    /**
     * 1.根据key对传来的map数据排序 2.生成a1=b1&a2=b2&a3=b3形式的字符串，排除某些字符串Key值 3.拼接MD5的key 4.调用digest方法进行md5编码
     *
     * @param map    要排序的字符串
     * @param md5Key MD5的key值
     * @param keys   要排除的key值
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String digest(Map<String, String> map, String md5Key, String... keys) {

        if (null == map || map.size() == 0) {
            return null;
        }
        TreeMap<String, String> treeMap = treeMap(map, keys);
        return digest(mapToString(treeMap, md5Key));
    }

    /**
     * 将map按key字符串排序的treeMap
     *
     * @param map
     * @param keys
     * @return
     */
    public static TreeMap<String, String> treeMap(Map<String, String> map, String... keys) {
        // 初始化字符串比较器
        Comparator<String> stringComparator = new StringComparator();

        TreeMap<String, String> treeMap = new TreeMap<String, String>(stringComparator);
        treeMap.putAll(map);
        // 移除非摘要的key
        for (String key : keys) {
            treeMap.remove(key);
        }
        return treeMap;
    }

    /**
     * 将map转成a1=b1&a2=b2&a3=b3形式的字符串，拼接MD5的key
     *
     * @param map
     * @param md5Key MD5的key值
     * @return
     */
    public static String mapToString(Map<String, String> map, String md5Key) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue() == null ? "" : entry.getValue().trim();
            result.append(entry.getKey()).append(CodecConstants.EQ_SYMBOL).append(value)
                    .append(CodecConstants.AND_SYMBOL);
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        result.append(CodecConstants.AND_SYMBOL).append(CodecConstants.KEY_STRING).append(CodecConstants.EQ_SYMBOL).append(md5Key);
        return result.toString().trim();
    }

}
