package com.bestpay.unioncashier.portal.web.controller.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * JSON转换类
 * Author: luwanchuan
 * Date: 2016/7/1
 */
public final class JsonConverter {

    /**
     * 私有，不暴露
     */
    private JsonConverter() {
    }

    /**
     * 简单对象转换为map，字段包含下划线
     *
     * @param object
     * @return
     */
    public static Map<String, String> objectToMap(Object object) {
        if (null == object) {
            return null;
        }
        JSONObject jsonObject = (JSONObject) JSON.toJSON(object);
        Map<String, String> map = new HashMap<String, String>();
        Set<String> sSet = jsonObject.keySet();
        for (String str : sSet) {
            map.put(str, String.valueOf(jsonObject.get(str)));
        }
        return map;
    }

    /**
     * JSONString 转为map
     *
     * @param jsonString
     * @return
     */
    public static Map<String, String> jsonStringToMap(String jsonString) {
        if (null == jsonString) {
            return null;
        }
        JSONObject jsonObject = JSON.parseObject(jsonString);
        Map<String, String> map = new HashMap<String, String>();
        Set<String> sSet = jsonObject.keySet();
        for (String str : sSet) {
            map.put(str, String.valueOf(jsonObject.get(str)));
        }
        return map;
    }

}
