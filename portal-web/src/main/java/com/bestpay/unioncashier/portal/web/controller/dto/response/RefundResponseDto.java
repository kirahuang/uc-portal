package com.bestpay.unioncashier.portal.web.controller.dto.response;

import com.alibaba.fastjson.annotation.JSONField;

import com.bestpay.unioncashier.portal.web.controller.dto.BaseResponseDto;
import lombok.ToString;

/**
 * 订单退款输入参数
 * Author: luwanchuan
 * Date: 2016/6/30
 */
@ToString(callSuper = true)
public class RefundResponseDto extends BaseResponseDto {

    /** 商户号 */
    private String merchantId;

    /** 商户唯一订单号 */
    private String outTradeNo;

    /** 详细错误码 */
    private String detailErrorcode;

    /** 订单状态 */
    private String orderState;

    /** 商户退款单号 */
    private String outRefundNo;

    /** 退款金额 */
    private Long   refundAmount;

    @JSONField(name = "merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    @JSONField(name = "merchant_id")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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

    @JSONField(name = "order_state")
    public String getOrderState() {
        return orderState;
    }

    @JSONField(name = "order_state")
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    @JSONField(name = "out_refund_no")
    public String getOutRefundNo() {
        return outRefundNo;
    }

    @JSONField(name = "out_refund_no")
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    @JSONField(name = "refund_amount")
    public Long getRefundAmount() {
        return refundAmount;
    }

    @JSONField(name = "refund_amount")
    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

}
