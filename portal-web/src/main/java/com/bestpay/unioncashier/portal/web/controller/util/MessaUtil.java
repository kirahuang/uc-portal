package com.bestpay.unioncashier.portal.web.controller.util;

/**
 * Created by xujunjie on 2016/7/6.
 */
public class MessaUtil {
    public final static String boxSignMessage(String jsonStr,String sign)throws Exception{
        return jsonStr.replace("}", ",\"sign\":\"" + sign + "\"}");
    }
}
