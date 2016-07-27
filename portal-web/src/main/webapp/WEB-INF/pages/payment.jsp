<%@ page import="java.util.Random" %>
<%@ page import="com.bestpay.utils.DateUtil" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head>
    <title>订单支付</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Bootstrap -->
    <link type="text/css" href="<%=path %>/css/web/bootstrap.min.css" rel="stylesheet" />
    <style type="text/css" rel="stylesheet">
        .he{height:20px}
    </style>
</head>

<body>
<div>
    <a href="/pages/index">返回</a>
</div>


<center>
    <form action="<%=basePath%>unioncashier/pay" method="post" >

        <table style="text-align: right;" >
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">接口名称</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="serviceo" name="service" value="unioncashier.trans.payment"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">版本号</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="version" name="version" value="V1.0"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">签名方式</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="signType" name="signType" value="MD5"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">商户号</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="merchantId" name="merchantId" value="20000000"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">商户唯一订单号</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="outTradeNo" name="outTradeNo" value="<%=com.bestpay.utils.DateUtil.getCurrent()%>" />
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">服务器异步通知页面路径</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="notifyUrl" name="notifyUrl" value="http://notify.bestpay.com.cn/nutify_receive.htm" />
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">订单标题</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="subject" name="subject" value="Apple iPhone 6s (A1700) 64G"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">订单业务类型</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="productCode" name="productCode" value="BARCODE"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">订单金额</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="totalAmount" name="totalAmount" value="1"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">商户操作员</span>
                </td>
                <td colspan="2">
                    <input type="text"  style="width: 200px"  class="form-control input-lg,he" id="operatorId" name="operatorId" value="M01"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">订单金额币种</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px"  class="form-control input-lg,he" id="currency" name="currency" value="156"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">动态授权ID</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="dynamicId" name="dynamicId" value="130057437649043176"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">门店编码</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="storeCode" name="storeCode" value="1233"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">终端编号</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="terminalCode" name="terminalCode" value="66723764291"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">公共业务扩展信息</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="extendParams" name="extendParams" value="<%=com.bestpay.utils.DateUtil.getCurrent()%>"/>
                </td>
            </tr>
        </table>

        <p>
            <button type="submit" class="btn btn-success btn-lg">提交</button>
        </p>
    </form>
</center>

</body>
</html>