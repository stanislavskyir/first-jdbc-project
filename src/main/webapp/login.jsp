<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 25.02.2025
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="email">Email:
        <input type="text" name="email" id="email" value="${param.email}" required>
    </label><br>
    <label for="password">Password:
        <input type="password" name="password" id="password" required>
    </label><br>
    <button type="submit">Login</button>
    <a href="${pageContext.request.contextPath}/registration">
        <button type="button">Register</button>
    </a>

    <c:if test="${param.error != null}}">
        <div style="color: red">
            <span>Email or password is not correct</span>
        </div>
    </c:if>
</form>
</body>
</html>
