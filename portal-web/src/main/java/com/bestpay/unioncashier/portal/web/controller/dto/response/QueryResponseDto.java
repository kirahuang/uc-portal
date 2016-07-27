package com.bestpay.unioncashier.portal.web.controller.dto.response;

import com.alibaba.fastjson.annotation.JSONField;

import com.bestpay.unioncashier.portal.web.controller.dto.BaseResponseDto;
import lombok.ToString;

/**
 * 订单查询输出参数
 * Author: luwanchuan
 * Date: 2016/6/30
 */
@ToString(callSuper = true)
public class QueryResponseDto extends BaseResponseDto {

    /** 商户号 */
    private String merchantId;

    /** 订单类型 */
    private String orderType;

    /** 商户唯一订单号 */
    private String outOrderNo;

    /** 详细错误码 */
    private String detailErrorcode;

    /** 订单状态 */
    private String orderState;

    /** 交易金额 */
    private Long   orderAmount;

    /** 该笔订单是否有退款,没有退款 0,完全退款 1,部分退款 2 */
    private String refundFlag;

    /** 已退款金额 */
    private Long   refundAmount;

    /** 交易时间 */
    private String tradeTime;

    @JSONField(name = "merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    @JSONField(name = "merchant_id")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @JSONField(name = "order_type")
    public String getOrderType() {
        return orderType;
    }

    @JSONField(name = "order_type")
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @JSONField(name = "out_order_no")
    public String getOutOrderNo() {
        return outOrderNo;
    }

    @JSONField(name = "out_order_no")
    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
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

    @JSONField(name = "order_amount")
    public Long getOrderAmount() {
        return orderAmount;
    }

    @JSONField(name = "order_amount")
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    @JSONField(name = "refund_flag")
    public String getRefundFlag() {
        return refundFlag;
    }

    @JSONField(name = "refund_flag")
    public void setRefundFlag(String refundFlag) {
        this.refundFlag = refundFlag;
    }

    @JSONField(name = "refund_amount")
    public Long getRefundAmount() {
        return refundAmount;
    }

    @JSONField(name = "refund_amount")
    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    @JSONField(name = "trade_time")
    public String getTradeTime() {
        return tradeTime;
    }

    @JSONField(name = "trade_time")
    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

}
