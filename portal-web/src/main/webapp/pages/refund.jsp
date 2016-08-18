<%@ page import="java.util.Random" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.*" %>
<%@ page import="com.bestpay.unioncashier.portal.web.controller.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head>
    <title>订单退款</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Bootstrap -->
    <link type="text/css" href="<%=path %>/css/web/bootstrap.min.css" rel="stylesheet" />
    <style type="text/css" rel="stylesheet">
        .he{height:30px}
    </style>
</head>

<body>
<div>
    <a href="javascript:window.history.go(-1)">返回</a>
</div>
<center>
    <br/>
    <form action="<%=basePath%>unioncashier/refund" method="post" >
        <table style="text-align: right">
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">接口名称</span>
                </td>
                <td >
                    <input type="text" class="form-control input-lg,he" id="service" name="service" value="unioncashier.trans.refund"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">版本号</span>
                </td>
                <td>
                    <input type="text" class="form-control input-lg,he" id="version" name="version" value="V1.0"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">签名方式</span>
                </td>
                <td>
                    <input type="text" class="form-control input-lg,he" id="signType" name="signType" value="MD5"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">商户号</span>
                </td>
                <td>
                    <input type="text" class="form-control input-lg,he" id="merchantId" name="merchantId" value="20000000"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">商户原交易订单号</span>
                </td>
                <td>
                 <div align="left">
                   <select id="outTradeNo" name="outTradeNo">

                
                <%
                
                for (Map.Entry<String, String> entry : OrderController.orderMap.entrySet()) {
                    if(entry.getValue().indexOf("PAY-")!=-1){
                    %>
                    <option value ="<%=entry.getKey() %>"><%=entry.getValue() %></option>
                    <%
                    }
                   }
           %>
               
                </select>
                </div>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">商户退款单号</span>
                </td>
                <td>
                    <input type="text" class="form-control input-lg,he" id="outRefundNo" name="outRefundNo" value="<%=DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now())%>"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">退款金额</span>
                </td>
                <td>
                    <input type="text" class="form-control input-lg,he" id="refundAmount" name="refundAmount" value="12"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">操作员类型</span>
                </td>
                <td>
                    <input type="text" class="form-control input-lg,he" id="operatorType" name="operatorType" value="1"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">操作员号</span>
                </td>
                <td>
                    <input type="text" class="form-control input-lg,he" id="operatorId" name="operatorId" value="M01"/>
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">公共业务扩展信息</span>
                </td>
                <td>
                    <input type="text" class="form-control input-lg,he" id="extendParams" name="extendParams" value="<%=DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now())%>"/>
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