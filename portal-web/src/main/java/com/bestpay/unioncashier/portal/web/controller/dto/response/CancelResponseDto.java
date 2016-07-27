package com.bestpay.unioncashier.portal.web.controller.dto.response;

import com.alibaba.fastjson.annotation.JSONField;

import com.bestpay.unioncashier.portal.web.controller.dto.BaseResponseDto;
import lombok.ToString;

/**
 * 订单撤销输出参数
 * Author: luwanchuan
 * Date: 2016/6/30
 */
@ToString(callSuper = true)
public class CancelResponseDto extends BaseResponseDto {

    /** 商户号 */
    private String merchantId;

    /** 订单状态 */
    private String orderState;

    /** 商户唯一订单号 */
    private String outTradeNo;

    /** 商户撤销订单号 */
    private String outCancelNo;

    /** 详细错误码 */
    private String detailErrorcode;

    /** 交易时间 */
    private String orderTime;

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

    @JSONField(name = "out_cancel_no")
    public String getOutCancelNo() {
        return outCancelNo;
    }

    @JSONField(name = "out_cancel_no")
    public void setOutCancelNo(String outCancelNo) {
        this.outCancelNo = outCancelNo;
    }

    @JSONField(name = "detail_error_code")
    public String getDetailErrorcode() {
        return detailErrorcode;
    }

    @JSONField(name = "detail_error_code")
    public void setDetailErrorcode(String detailErrorcode) {
        this.detailErrorcode = detailErrorcode;
    }

    @JSONField(name = "order_time")
    public String getOrderTime() {
        return orderTime;
    }

    @JSONField(name = "order_time")
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

}
