<%--
  Created by IntelliJ IDEA.
  User: xujunjie
  Date: 2016/7/7
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>主页面</title>
</head>
<body>
    <table>
        <tr>
            <td>
                <a href="<%=basePath%>pages/prepayment">订单支付页面</a>
            </td>
        </tr>
        <tr>
            <td>
                <a href="<%=basePath%>pages/cancel">订单撤销页面</a>
            </td>
        </tr>
       <tr>
           <td>
               <a href="<%=basePath%>pages/refund">订单退款页面</a>
           </td>
       </tr>
        <tr>
            <td>
                <a href="<%=basePath%>pages/query">订单查询页面</a>
            </td>
        </tr>

    </table>

</body>
</html>
