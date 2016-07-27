package com.bestpay.unioncashier.portal.web.controller.dto.response;

import com.alibaba.fastjson.annotation.JSONField;

import com.bestpay.unioncashier.portal.web.controller.dto.BaseResponseDto;
import lombok.ToString;

/**
 * 支付输出参数
 * Author: luwanchuan
 * Date: 2016/6/30
 */
@ToString(callSuper = true)
public class PaymentResponseDto extends BaseResponseDto {

    /** 商户号 */
    private String merchantId;

    /** 订单状态 */
    private String orderState;

    /** 商户唯一订单号 */
    private String outTradeNo;

    /** 详细错误码 */
    private String detailErrorcode;

    /** 交易金额 */
    private Long   totalAmount;

    /** 交易付款时间 */
    private String gmtPayment;

    @JSONField(name = "merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    @JSONField(name = "merchant_id")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @JSONField(name = "order_state")
    public String getOrderState() {
        return orderState;
    }

    @JSONField(name = "order_state")
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    @JSONField(name = "out_trade_no")
    public String getOutTradeNo() {
        return outTradeNo;
    }

    @JSONField(name = "out_trade_no")
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @JSONField(name = "detail_error_code")
    public String getDetailErrorcode() {
        return detailErrorcode;
    }

    @JSONField(name = "detail_error_code")
    public void setDetailErrorcode(String detailErrorcode) {
        this.detailErrorcode = detailErrorcode;
    }

    @JSONField(name = "total_amount")
    public Long getTotalAmount() {
        return totalAmount;
    }

    @JSONField(name = "total_amount")
    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JSONField(name = "gmt_payment")
    public String getGmtPayment() {
        return gmtPayment;
    }

    @JSONField(name = "gmt_payment")
    public void setGmtPayment(String gmtPayment) {
        this.gmtPayment = gmtPayment;
    }

}
