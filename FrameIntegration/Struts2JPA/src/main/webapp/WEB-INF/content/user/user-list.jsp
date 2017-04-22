<%--
  Created by IntelliJ IDEA.
  User: yuyufeng
  Date: 2017/4/22
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Uer测试</h1>
<s:debug></s:debug>
<table>
    <tr><th>用户编号</th><th>用户ID</th></tr>
    <s:iterator value="#page.content">
        <tr>
            <td>${userId}</td>
            <td>${userName}</td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
