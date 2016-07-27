package com.bestpay.unioncashier.portal.web.controller.dto;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.ToString;

/**
 * 服务路由输出参数
 * Author: luwanchuan
 * Date: 2016/7/13
 */
@ToString
public class BaseResponseDto {

    /** 是否成功, T 代表成功, F 代表失败 */
    private String isSuccess;

    /** 签名方式 */
    private String signType;

    /** 签名 */
    private String sign;

    /** 错误码 */
    private String errorCode;

    /** 错误描述 */
    private String errorMsg;

    @JSONField(name = "is_success")
    public String getIsSuccess() {
        return isSuccess;
    }

    @JSONField(name = "is_success")
    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    @JSONField(name = "sign_type")
    public String getSignType() {
        return signType;
    }

    @JSONField(name = "sign_type")
    public void setSignType(String signType) {
        this.signType = signType;
    }

    @JSONField(name = "sign")
    public String getSign() {
        return sign;
    }

    @JSONField(name = "sign")
    public void setSign(String sign) {
        this.sign = sign;
    }

    @JSONField(name = "error_code")
    public String getErrorCode() {
        return errorCode;
    }

    @JSONField(name = "error_code")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @JSONField(name = "error_msg")
    public String getErrorMsg() {
        return errorMsg;
    }

    @JSONField(name = "error_msg")
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
