package com.bestpay.unioncashier.portal.test;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bestpay.unioncashier.portal.web.controller.util.HttpClientUtil;
import com.bestpay.unioncashier.portal.web.controller.util.JsonConverter;
import com.bestpay.unioncashier.portal.web.controller.util.MessaUtil;
import com.bestpay.unioncashier.portal.web.controller.util.SignValidateUtil;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class OrderControllerHelper2 {

    //加密的钥匙
    @Value("${TEST_KEY}")
    private String         TEST_KEY;

    //测试地址
    @Value("${TEST_URL}")
    private String         TEST_URL;

    @Autowired
    private HttpClientUtil httpClientUtil;

    public String requestToHttpServer(Map<String, String> map) {
        String sign;
        String postMsg;
        try {
            System.out.println("begin>>>>>>>>>>>>>>>>>>>"+JSON.toJSONString(map));
            sign = SignValidateUtil.sign(map, TEST_KEY, "sign");
            postMsg = MessaUtil.boxSignMessage(JSON.toJSONString(map), sign);
        } catch (Exception e) {
            log.error("签名失败", e);
            return e.getMessage();
        }
        log.info("签名成功，签名值:{}:", sign);

        //发送请求
        String result = httpClientUtil.sendHttpJsonRequest(TEST_URL +"service.do", postMsg);
        System.out.println("end>>>>>>>>>>>>>>>>>>>"+result);
        return result;
    }

    /**
     *  验签
     * @param jsonString
     */
    public boolean validate(Map<String, String> map) {
        boolean result=false;
        try {
            result = SignValidateUtil.validate(map, map.get("sign"), TEST_KEY, "sign");
            log.info("验签,验签结果: {}", result);
        } catch (Exception e) {
            log.info("验签,验签发生错误.", e);
        }
        return result;
    }

}
