package com.bestpay.unioncashier.portal.web.controller.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.bestpay.unioncashier.portal.web.controller.dto.BaseRequestDto;
import lombok.ToString;

/**
 * 订单查询输入参数
 * Author: luwanchuan
 * Date: 2016/6/30
 */
@ToString(callSuper = true)
public class QueryRequestDto extends BaseRequestDto {

    /** 商户唯一订单号 */
    private String outOrderNo;

    /** 订单类型：Enum：PAY 支付交易；REFUND 退款；CANCEL 撤销 */
    private String orderType;

    @JSONField(name = "out_order_no")
    public String getOutOrderNo() {
        return outOrderNo;
    }

    @JSONField(name = "out_order_no")
    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    @JSONField(name = "order_type")
    public String getOrderType() {
        return orderType;
    }

    @JSONField(name = "order_type")
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

}
