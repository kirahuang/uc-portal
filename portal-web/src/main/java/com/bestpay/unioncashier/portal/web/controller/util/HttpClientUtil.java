package com.bestpay.unioncashier.portal.web.controller.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Http请求发送工具类
 * <p>
 * </p>
 * User: Jiaju Date: 2016/05/16 ProjectName: purepay Version: 1.0
 */
@Component
@Slf4j
public class HttpClientUtil {

    /**
     *   Web消息请求发送Bean
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     *   发送报文的媒体类型
     */
    private final String APP_JSON_MEDIA_TYPE = "application/json; charset=UTF-8";

    /**
     *
     * 向目标系统发送http请求
     * 报文格式application/json; charset=UTF-8
     *
     * @param url         地址
     * @param jsonMsg     json格式报文
     * @return 返回信息
     * @throws Exception 异常
     */
    public String sendHttpJsonRequest(String url, String jsonMsg){

        //设置HTTP Header
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType(APP_JSON_MEDIA_TYPE);
        headers.setContentType(type);

        //组成Http报文
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonMsg, headers);
        log.debug("http报文{}",formEntity);
        //发送HTTP报文
        String result = restTemplate.postForObject(url, formEntity, String.class);
        log.debug("返回的数据{}",result);
        return result;
    }
}
