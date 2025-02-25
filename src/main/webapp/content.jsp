<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 23.02.2025
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <span>Content</span>
    <p>Size: ${requestScope.flights.size()}</p>
    <p>Description: ${requestScope.flights.get(0).description()}</p>
</div>

</body>
</html>
