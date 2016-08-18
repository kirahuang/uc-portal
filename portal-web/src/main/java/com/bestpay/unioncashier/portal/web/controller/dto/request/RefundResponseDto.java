package com.bestpay.unioncashier.portal.web.controller.dto.request;

import lombok.ToString;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 订单退款输入参数
 * Author: luwanchuan
 * Date: 2016/6/30
 */
@ToString
public class RefundResponseDto  {

    /** 商户唯一订单号 */
    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    /** 商户退款单号 */
    @JSONField(name = "out_refund_no")
    private String outRefundNo;

    /** 此请求次否成功处理 */
    @JSONField(name = "is_success")
    private String isSuccess;

    /** 订单状态 */
    @JSONField(name = "order_state")
    private String orderState;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
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

   

}
