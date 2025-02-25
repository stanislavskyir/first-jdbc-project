<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 24.02.2025
  Time: 01:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="post">
  <label for="name">Name:
    <input type="text" name="name" id="name">
  </label><br/>
  <label for="birthday">Birthday
    <input type="date" name="birthday" id="birthday">
  </label></br>
  <label for="email">Email:
    <input type="text" name="email" id="email">
  </label></br>
  <label for="pwd">Password:
    <input type="password" name="pwd" id="pwd">
  </label></br>


<%--  <c:forEach var="role" items="${requestScope.roles}">--%>
<%--    <option label="${role}">${role}</option><br>--%>
<%--  </c:forEach>--%>

  <label for="role">Role:
    <select name="role" id="role">
      <c:forEach var="role" items="${requestScope.roles}">
        <option value="${role}">${role}</option>
      </c:forEach>
    </select>
  </label><br/>

  <c:forEach var="gender" items="${requestScope.genders}">
    <input type="radio" name="gender" VALUE="${gender}"> ${gender}
    <br/>
  </c:forEach>
  <input type="submit" value="Send">
</form>

<c:if test="${not empty requestScope.errors}">
  <div style="color: red">
    <c:forEach var="error" items="${requestScope.errors}">
      <span>${error.message}</span>
      <br>
    </c:forEach>
  </div>
</c:if>

</body>
</html>
