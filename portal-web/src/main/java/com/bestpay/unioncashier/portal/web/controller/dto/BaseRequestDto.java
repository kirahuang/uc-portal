package com.bestpay.unioncashier.portal.web.controller.dto;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.ToString;

/**
 * 交易请求基础输入参数
 * Author: luwanchuan
 * Date: 2016/7/18
 */
@ToString
public class BaseRequestDto {

    /** 接口名称 */
    private String service;

    /** 版本号 */
    private String version;

    /** 签名方式 */
    private String signType;

    /** 签名 */
    private String sign;

    /** 商户号 */
    private String merchantId;

    /** 公共业务扩展信息 */
    private String extendParams;

    @JSONField(name = "sign_type")
    public String getSignType() {
        return signType;
    }

    @JSONField(name = "sign_type")
    public void setSignType(String signType) {
        this.signType = signType;
    }

    @JSONField(name = "service")
    public String getService() {
        return service;
    }

    @JSONField(name = "service")
    public void setService(String service) {
        this.service = service;
    }

    @JSONField(name = "version")
    public String getVersion() {
        return version;
    }

    @JSONField(name = "version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JSONField(name = "sign")
    public String getSign() {
        return sign;
    }

    @JSONField(name = "sign")
    public void setSign(String sign) {
        this.sign = sign;
    }

    @JSONField(name = "merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    @JSONField(name = "merchant_id")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @JSONField(name = "extend_params")
    public String getExtendParams() {
        return extendParams;
    }

    @JSONField(name = "extend_params")
    public void setExtendParams(String extendParams) {
        this.extendParams = extendParams;
    }

}
