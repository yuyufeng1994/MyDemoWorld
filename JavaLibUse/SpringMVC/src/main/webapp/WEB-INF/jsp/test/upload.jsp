<%--
  Created by IntelliJ IDEA.
  User: yuyufeng
  Date: 2017/5/16
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传Test</title>
</head>
<body>
<h1>上传</h1>
<form action="upload-file" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="提交">
</form>
</body>
</html>
