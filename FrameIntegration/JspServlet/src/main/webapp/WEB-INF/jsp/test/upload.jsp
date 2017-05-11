<%--
  Created by IntelliJ IDEA.
  User: yuyufeng
  Date: 2017/5/11
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>上传测试</title>
</head>
<body>
<h1>上传测试</h1>
<h1>${message}</h1>
<form action="/upload" method="post" enctype="multipart/form-data">
    文件名称：<input name="fileName" type="text"><br/>
    <input type="file" name="file1"><br/>
    <input type="submit" value="立即上传">
</form>
</body>
</html>
