package com.bestpay.unioncashier.portal.web.controller.dto.request;

import lombok.ToString;

import com.alibaba.fastjson.annotation.JSONField;

@ToString
public class PaymentResponseDto  {

    /** 商户唯一订单号 */
    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    /** 此请求次否成功处理 */
    @JSONField(name = "is_success")
    private String isSuccess;

    /** 订单状态 */
    @JSONField(name = "order_state")
    private String orderState;


    /** 订单金额,该笔订单的资金总额,单位分 */
    @JSONField(name = "total_amount")
    private Long   totalAmount;


    public String getOutTradeNo() {
        return outTradeNo;
    }


    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }


    public String getIsSuccess() {
        return isSuccess;
    }


    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }


    public String getOrderState() {
        return orderState;
    }


    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }


    public Long getTotalAmount() {
        return totalAmount;
    }


    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }




}
