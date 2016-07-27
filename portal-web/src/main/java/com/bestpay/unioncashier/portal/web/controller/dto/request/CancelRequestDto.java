package com.bestpay.unioncashier.portal.web.controller.dto.request;

import com.alibaba.fastjson.annotation.JSONField;

import com.bestpay.unioncashier.portal.web.controller.dto.BaseRequestDto;
import lombok.ToString;

/**
 * 订单撤销输入参数
 * Author: luwanchuan
 * Date: 2016/6/30
 */
@ToString(callSuper = true)
public class CancelRequestDto extends BaseRequestDto {

    /** 商户唯一订单号 */
    private String outTradeNo;

    /** 商户撤销订单号 */
    private String outCancelNo;

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

}
