<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 21.11.2018
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Вы действительно хотите удалить пользователя
<% if (request.getAttribute("name")!= null){
    out.print("<p>"+request.getAttribute("name")+"</p>");
}%>

<form action="/list/${param.name}" method="post">
<input type="hidden" name="name" value="${param.name}">
<input type="hidden" name="_method" value="delete">
<input type="submit" value="Удалить">
</form>

</body>
</html>
