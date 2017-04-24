<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <%@ include file="/WEB-INF/jsp/include/head.jsp" %>
</head>
<body>
<h1>用户列表</h1>
<c:forEach var="u" items="${page.list}">
    <p>${u.userId} ,${u.userName}  </p>
</c:forEach>
</body>
</html>
