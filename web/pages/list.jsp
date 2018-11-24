<%@ page import="java.util.List" %>
<%@ page import="app.entities.Hero" %><%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 18.11.2018
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hero List</title>
    <link href="css/styleC.css" rel="stylesheet" type="text/css" />

</head>
<body>
<%
    String alive =request.getParameter("alive");
    if(alive!=null){
        if(Boolean.parseBoolean(alive)){
            out.print("<h1 class=\"head_h\">Surviving heroes</h1>");
        }
        else{
            out.print("<h1 class=\"head-h\">Lost heroes</h1>");
        }
    }
%>

<div>
   <ul class="ul-size">
    <li>
        <div class="container">
            <div class="card">
                <div class="card-head">
                    <img src="images/add.jpg" alt="logo" class="card-logo">
                </div>
                <div class="card-body">
                    <div class="product-desc">
                <span class="product-title">
                        <h2>Add Super Hero</h2>
                        <h3>Universe</h3>
                </span>
                        <span class="product-caption">
                       <p class="product">Description</p>
                      </span>
                        <center><button class ="buttons" onclick="location.href='/add'">Create</button></center>
                    </div>
                </div>
            </div>
        </div>
    </li>
    <%
        List<Hero> heroes = (List<Hero>) request.getAttribute("heroes");
        %><
        <%if (heroes != null && !heroes.isEmpty()) {

            for (Hero s : heroes) {%>
                 <li>
                  <div class="container">
                  <div class="card\">
                    <div class="card-head">
                      <img src="images/add.jpg" alt="logo" class="card-logo">
                    </div>
                    <div class="card-body">
                      <div class="product-desc">
                        <span class="product-title">
                                <h2><%=s.getName()%></h2>
                                <b><%=s.getUniverse()%></b>
                        </span>
                        <span class="product-caption">
                               <p class="product"><%=s.getDescreption()%></p>
                        </span>
                      <center>
                          <button class ="buttons" onclick="location.href='/hero?name=<%=s.getName()%>'">View</button>
                          <button class ="buttons" onclick="location.href='/add?name=<%=s.getName()%>'">Update</button>
                          <form method="delete"><input type="hidden" name="name"value="<%=s.getName()%>"><button class ="buttons" type="submit">Delete</button></form>
                        </center>
                      </div>
                    </div>
                  </div>
                </div>
                 </li>
            <%}%>
       <%}%>
   </ul>

</div>
</body>
</html>
