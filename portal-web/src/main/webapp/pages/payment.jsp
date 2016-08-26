<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.util.Random" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
%>
<head>
    <title>订单支付</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style type="text/css" rel="stylesheet">
        .he{height:20px}
    </style>
    <script language="JavaScript"src="../js/jquery-1.7.2.min.js"></script>
    <script>


$(function(){
    /*进入焦点时触发*/
     $("#dynamicId").focus();
   
});
</script>
</head>

<body >
<div>
    <a href="javascript:window.history.go(-1)">返回</a>
</div>


<center>
    <form action="<%=basePath%>unioncashier/pay" method="post" >

        <table style="text-align: right;" >
        <tr style="height: 25px">
                <td colspan="3">
                    <h1><font color="red">请扫描枪扫码</font></h1>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">接口名称</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="service" name="service" value="<%=request.getParameter("service")%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">版本号</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="version" name="version" value="<%=request.getParameter("version")%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">签名方式</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="signType" name="signType" value="<%=request.getParameter("signType")%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">商户号</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="merchantId" name="merchantId" value="<%=request.getParameter("merchantId")%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">商户唯一订单号</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="outTradeNo" name="outTradeNo" value="<%=request.getParameter("outTradeNo")%>" />
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">服务器异步通知页面路径</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="notifyUrl" name="notifyUrl" value="<%=request.getParameter("notifyUrl")%>" />
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">订单标题</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="subject" name="subject" value="<%=request.getParameter("subject")%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">订单业务类型</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="productCode" name="productCode" value="<%=request.getParameter("productCode")%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">订单金额</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="totalAmount" name="totalAmount" value="<%=request.getParameter("totalAmount")%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">商户操作员</span>
                </td>
                <td colspan="2">
                    <input type="text"  style="width: 200px"  class="form-control input-lg,he" id="operatorId" name="operatorId" value="<%=request.getParameter("operatorId")%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">订单金额币种</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px"  class="form-control input-lg,he" id="currency" name="currency" value="<%=request.getParameter("currency")%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">动态授权ID</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="dynamicId" name="dynamicId" value=""/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">门店编码</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="storeCode" name="storeCode" value="<%=request.getParameter("storeCode")%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">终端编号</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="terminalCode" name="terminalCode" value="<%=request.getParameter("terminalCode")%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">公共业务扩展信息</span>
                </td>
                <td colspan="2">
                    <input type="text" style="width: 200px" class="form-control input-lg,he" id="extendParams" name="extendParams" value="<%=request.getParameter("extendParams")%>"/>
                </td>
            </tr>
        </table>

        <p>
            <button type="submit" class="btn btn-success btn-lg">订单确认(扫描枪用户请不要点击此按钮!)</button>
        </p>
    </form>
</center>

</body>
</html>