<%@ page import="app.entities.Hero" %>
<%@ page import="java.util.List" %>
<%@ page import="app.model.Model" %><%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 22.11.2018
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%Hero hero =(Hero) request.getAttribute("hero");%>
    <p><%=hero.getName()%></p>
    <p><%=hero.getUniverse()%></p>
    <p><%=hero.getPower()%></p>
    <p><%=hero.getPhone()%></p>
    <p><%=hero.getDescreption()%></p>
</body>
</html>
