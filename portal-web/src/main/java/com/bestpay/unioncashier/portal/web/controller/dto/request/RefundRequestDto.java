package com.bestpay.unioncashier.portal.web.controller.dto.request;

import com.alibaba.fastjson.annotation.JSONField;

import com.bestpay.unioncashier.portal.web.controller.dto.BaseRequestDto;
import lombok.ToString;

/**
 * 订单退款输入参数
 * Author: luwanchuan
 * Date: 2016/6/30
 */
@ToString(callSuper = true)
public class RefundRequestDto extends BaseRequestDto {

    /** 商户唯一订单号 */
    private String outTradeNo;

    /** 商户退款单号 */
    private String outRefundNo;

    /** 退款金额 */
    private Long   refundAmount;

    /** 操作员类型 */
    private String operatorType;

    /** 操作员号 */
    private String operatorId;

    @JSONField(name = "out_trade_no")
    public String getOutTradeNo() {
        return outTradeNo;
    }

    @JSONField(name = "out_trade_no")
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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

    @JSONField(name = "operator_type")
    public String getOperatorType() {
        return operatorType;
    }

    @JSONField(name = "operator_type")
    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    @JSONField(name = "operator_id")
    public String getOperatorId() {
        return operatorId;
    }

    @JSONField(name = "operator_id")
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

}
