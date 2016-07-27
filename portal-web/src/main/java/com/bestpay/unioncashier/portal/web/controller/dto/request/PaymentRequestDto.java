package com.bestpay.unioncashier.portal.web.controller.dto.request;

import com.alibaba.fastjson.annotation.JSONField;

import com.bestpay.unioncashier.portal.web.controller.dto.BaseRequestDto;
import lombok.ToString;

/**
 * 支付输入参数
 * Author: luwanchuan
 * Date: 2016/6/30
 */
@ToString(callSuper = true)
public class PaymentRequestDto extends BaseRequestDto {

    /** 商户唯一订单号 */
    private String outTradeNo;

    /** 服务器异步通知页面路径,翼支付服务器主动通知商户网站里指定的页面http路径 */
    private String notifyUrl;

    /** 订单标题,商品的标题/交易标题/订单标题/订单关键字等。该参数最长为 128 个汉字 */
    private String subject;

    /** 订单业务类型,BARCODE：条码支付 */
    private String productCode;

    /** 订单金额,该笔订单的资金总额,单位分 */
    private Long   totalAmount;

    /** 商户操作员id */
    private String operatorId;

    /** 订单金额币种,目前只支持传入 156（人民币）。默认设置为156 */
    private String currency;

    /** 动态授权ID */
    private String dynamicId;

    /** 门店编码 */
    private String storeCode;

    /** 终端编号 */
    private String terminalCode;

    @JSONField(name = "out_trade_no")
    public String getOutTradeNo() {
        return outTradeNo;
    }

    @JSONField(name = "out_trade_no")
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @JSONField(name = "notify_url")
    public String getNotifyUrl() {
        return notifyUrl;
    }

    @JSONField(name = "notify_url")
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @JSONField(name = "subject")
    public String getSubject() {
        return subject;
    }

    @JSONField(name = "subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JSONField(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    @JSONField(name = "product_code")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @JSONField(name = "total_amout")
    public Long getTotalAmount() {
        return totalAmount;
    }

    @JSONField(name = "total_amout")
    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JSONField(name = "operator_id")
    public String getOperatorId() {
        return operatorId;
    }

    @JSONField(name = "operator_id")
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    @JSONField(name = "currency")
    public String getCurrency() {
        return currency;
    }

    @JSONField(name = "currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JSONField(name = "dynamic_id")
    public String getDynamicId() {
        return dynamicId;
    }

    @JSONField(name = "dynamic_id")
    public void setDynamicId(String dynamicId) {
        this.dynamicId = dynamicId;
    }

    @JSONField(name = "store_code")
    public String getStoreCode() {
        return storeCode;
    }

    @JSONField(name = "store_code")
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    @JSONField(name = "terminal_code")
    public String getTerminalCode() {
        return terminalCode;
    }

    @JSONField(name = "terminal_code")
    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

}
