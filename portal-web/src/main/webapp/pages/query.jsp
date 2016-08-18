<%@ page import="java.util.Random" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head>
    <title>订单查询</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style type="text/css" rel="stylesheet">
        .he{height:20px}
    </style>
    <script language="JavaScript"src="../js/jquery-1.7.2.min.js"></script>
     <script>
     $(document).ready(function () {
         $('#orderType').change(function(){
        	 alert($(this).val()); 
        	   //清除二级下拉列表
        	 <%--   $("#outOrderNo").empty();
        	   
        	   $.post(<%=basePath%>+'pages/orderSelect?type='+$(this).val(),function(result){
        		    alert(111);
        		  }); --%>
        	   
        		  $.getJSON('<%=basePath%>pages/orderSelect', { type: $(this).val() },function(result){
        			     $.each(result, function(i, field){
        			      $("#outOrderNo").append($("<option/>").text(field).attr("value",i));
        			      
        			      
        			    }); 
        			  });
        	 
         });
     });
</script>
</head>

<body>
<div>
    <a href="javascript:window.history.go(-1)">返回</a>
</div>
<center>
    <form action="<%=basePath%>unioncashier/query" method="post" >
        <center>查询的业务类型：PAY 支付交易，REFUND 退款，CANCEL 撤销</center>
        <br/>
        <table style="text-align: right">
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">接口名称</span>
                </td>
                <td>
                    <input type="text" class="form-control input-lg,he" id="service" name="service" value="unioncashier.order.query"/>
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
                    <span class="input-group-addon">商户号</span>
                </td>
                <td>
                    <input type="text" class="form-control input-lg,he" id="merchantId" name="merchantId" value="20000000"/>
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
                    <span class="input-group-addon">业务类型</span>
                </td>
                <td>
                <div align="left">
                <select id="orderType" name="orderType">
				  <option value ="PAY">支付交易</option>
				  <option value ="REFUND">退款交易</option>
				  <option value="CANCEL">撤销交易</option>
				</select>
                
                </div>
                
                
                </td>
            </tr>
            <tr style="height: 25px">
                <td>
                    <span class="input-group-addon">商户唯一订单号</span>
                </td>
                <td>
                <div align="left">
                
                  <select id="outOrderNo" name="outOrderNo" />
                    <!-- <input type="text" class="form-control input-lg,he" id="outOrderNo" name="outOrderNo" value=""/> -->
                </div>
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


        <span>
            <button type="submit" class="btn btn-success btn-lg">提交</button>
        </span>
    </form>



</center>
</body>
</html>