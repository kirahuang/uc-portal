package com.bestpay.unioncashier.portal.web.controller;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bestpay.unioncashier.portal.web.controller.dto.request.CancelRequestDto;
import com.bestpay.unioncashier.portal.web.controller.dto.request.PaymentRequestDto;
import com.bestpay.unioncashier.portal.web.controller.dto.request.QueryRequestDto;
import com.bestpay.unioncashier.portal.web.controller.dto.request.RefundRequestDto;
import com.bestpay.unioncashier.portal.web.controller.dto.response.CancelResponseDto;
import com.bestpay.unioncashier.portal.web.controller.dto.response.PaymentResponseDto;
import com.bestpay.unioncashier.portal.web.controller.dto.response.RefundResponseDto;
import com.bestpay.unioncashier.portal.web.controller.helper.OrderControllerHelper;
import com.bestpay.unioncashier.portal.web.controller.util.JsonConverter;

/**
 * 统一收银台操作
 * <p>
 * </p>
 * User: Jiaju Date: 2016/04/21 ProjectName: oms Version: 1.0
 */
@Slf4j
@Controller
@RequestMapping(value = "unioncashier")
public class OrderController {

    @Autowired
    private OrderControllerHelper orderControllerHelper;

    //加密的钥匙
    @Value("${TEST_KEY}")
    private String                TEST_KEY;

    //商户号
    @Value("${TEST_URL}")
    private String                TEST_URL;
    
    //map
    public static Map<String,String> orderMap = new HashMap<>();
    

    /**
     * 支付订单操作
     *
     * @param paymentRequestDto
     * @return
     */
    @RequestMapping(value = "/pay")
    @ResponseBody
    public String pay(PaymentRequestDto paymentRequestDto) {
        try {
            log.info("支付对象的数据：{}", paymentRequestDto);
            Map<String, String> map = JsonConverter.objectToMap(paymentRequestDto);

            //发送请求
            String result = orderControllerHelper.requestToHttpServer(map, paymentRequestDto, "service.do");

            log.info("支付请求结果{}", result);
            
            PaymentResponseDto response = JSONObject.parseObject(result, PaymentResponseDto.class);
            
            // 验签
            if(orderControllerHelper.validate(result) && response!=null && response.getIsSuccess().equals("T")&& response.getOrderState().equals("SUCCESS")){
                orderMap.put(response.getOutTradeNo(), "PAY-"+response.getOutTradeNo());
            }

            return result;
        } catch (Exception e) {
            log.error("HTTP调用发生异常:{}");
            return e.getMessage();
        }
    }

    /**
     * 订单撤销操作
     *
     * @param cancelRequestDto
     * @return
     */
    @RequestMapping(value = "/cancel")
    @ResponseBody
    public String cancel(CancelRequestDto cancelRequestDto) {
        try {
            log.info("撤销订单数据:{}", cancelRequestDto);
            //将对象转换为map
            Map<String, String> map = JsonConverter.objectToMap(cancelRequestDto);

            //发送请求
            String result = orderControllerHelper.requestToHttpServer(map, cancelRequestDto, "service.do");

            
            CancelResponseDto response = JSONObject.parseObject(result, CancelResponseDto.class);
            
            log.info("撤销请求结果{}", result);
            // 验签
            if(orderControllerHelper.validate(result)&& response!=null && response.getIsSuccess().equals("T")&& response.getOrderState().equals("SUCCESS")){
                orderMap.put(response.getOutCancelNo(), "CANCEL-"+response.getOutCancelNo());
            }

            return result;
        } catch (Exception e) {
            log.error("HTTP调用发生异常:{}");
            return e.getMessage();
        }
    }

    /**
     * 订单退款操作
     *
     * @param refundRequestDto
     * @return
     */
    @RequestMapping(value = "/refund")
    @ResponseBody
    public String refund(RefundRequestDto refundRequestDto) {
        try {
            log.info("退订订单数据:{}", refundRequestDto);
            //将对象转换为map
            Map<String, String> map = JsonConverter.objectToMap(refundRequestDto);
            //发送请求
            String result = orderControllerHelper.requestToHttpServer(map, refundRequestDto, "service.do");
            log.info("退款请求结果{}", result);
            RefundResponseDto response = JSONObject.parseObject(result, RefundResponseDto.class);
            // 验签
           if( orderControllerHelper.validate(result) && response!=null && response.getIsSuccess().equals("T")&& response.getOrderState().equals("SUCCESS")){
                orderMap.put(response.getOutRefundNo(), "REFUND-"+response.getOutRefundNo());
            }
            return result;
        } catch (Exception e) {
            log.error("HTTP调用发生异常:{}");
            return e.getMessage();
        }
    }

    /**
     * 订单查询操作
     *
     * @param queryRequestDto
     * @return
     */
    @RequestMapping(value = "/query")
    @ResponseBody
    public String execute(QueryRequestDto queryRequestDto) {
        try {
            log.info("订单查询数据", queryRequestDto);
            //加签    生成Json字符串msg
            Map<String, String> map = JsonConverter.objectToMap(queryRequestDto);

            //发送请求
            String result = orderControllerHelper.requestToHttpServer(map, queryRequestDto, "service.do");
            log.info("订单查询请求结果{}", result);
            // 验签
            orderControllerHelper.validate(result);

            return result;
        } catch (Exception e) {
            log.error("HTTP调用发生异常:{}");
            return e.getMessage();
        }
    }

}
