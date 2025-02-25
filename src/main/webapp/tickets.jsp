<%@ page import="org.example.service.TicketService" %>
<%@ page import="org.example.dto.TicketDto" %><%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 23.02.2025
  Time: 19:53
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
<%@include file="header.jsp"%>
<h1>Purchased tickets:</h1>
<ul>
    <c:forEach var="ticket" items="${requestScope.tickets}">
        <li>${ticket.seatNo()}</li>
    </c:forEach>
</ul>
</body>
</html>
