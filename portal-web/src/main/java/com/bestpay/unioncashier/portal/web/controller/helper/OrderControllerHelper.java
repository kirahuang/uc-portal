package com.bestpay.unioncashier.portal.web.controller.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bestpay.unioncashier.portal.web.controller.util.HttpClientUtil;
import com.bestpay.unioncashier.portal.web.controller.util.JsonConverter;
import com.bestpay.unioncashier.portal.web.controller.util.MessaUtil;
import com.bestpay.unioncashier.portal.web.controller.util.SignValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 类注释
 * <p>
 * </p>
 * User: Jiaju Date: 2016/07/08 ProjectName: oms Version: 1.0
 */
@Slf4j
@Component
public class OrderControllerHelper {

    //加密的钥匙
    @Value("${TEST_KEY}")
    private String         TEST_KEY;

    //测试地址
    @Value("${TEST_URL}")
    private String         TEST_URL;

    @Autowired
    private HttpClientUtil httpClientUtil;

    public String requestToHttpServer(Map<String, String> map, Object sendObject,
                                      String actionUrl) {
        String sign;
        String postMsg;
        try {
            sign = SignValidateUtil.sign(map, TEST_KEY, "sign");
            JSONObject jsonObject = (JSONObject) JSON.toJSON(sendObject);
            postMsg = MessaUtil.boxSignMessage(JSON.toJSONString(jsonObject), sign);
        } catch (Exception e) {
            log.error("签名失败", e);
            return e.getMessage();
        }
        log.info("签名成功，签名值:{}:", sign);

        //发送请求
        String result = httpClientUtil.sendHttpJsonRequest(TEST_URL + actionUrl, postMsg);

        return result;
    }

    /**
     *  验签
     * @param jsonString
     */
    public void validate(String jsonString) {
        Map<String, String> map = JsonConverter.jsonStringToMap(jsonString);
        try {
            boolean result = SignValidateUtil.validate(map, map.get("sign"), TEST_KEY, "sign");
            log.info("验签,验签结果: {}", result);
        } catch (Exception e) {
            log.info("验签,验签发生错误.", e);
        }
    }

}
