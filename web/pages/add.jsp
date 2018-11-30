<%@ page import="app.model.Model" %>
<%@ page import="app.entities.Hero" %><%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 18.11.2018
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <link rel="stylesheet" href="css/StyleF.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Add Hero</h1>
</div>
<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-card-4">
            <%--<p><!% request.getAttribute("heroName")%></p>--%>
<%
    if ((request.getAttribute("heroName")) != null && (request.getAttribute("active") != null)) {
        out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                "   <h5>User '" + request.getAttribute("heroName") + "\'"+ request.getAttribute("active")+"</h5>\n" +
                "</div>");
    }
%>
    <% Hero hero = (Hero)request.getAttribute("hero");
        String name="";
        String id="";
        String universe="";
        String power="";
        String description="";
        boolean alive =false;
        String telephone="";

        if(hero!=null) {
            name = hero.getName();
            universe = hero.getUniverse();
            power = Integer.toString(hero.getPower());
            description = hero.getDescreption();
            alive = hero.isAlive();
            telephone = hero.getPhone();
        }
        %>
                <form method="post" class="w3-selection w3-light-grey w3-padding">
                 <p><b>Имя супергероя:</b><br>
                     <input type="text" name="name" size="40" value="<%=name%>" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
                 </p>

                     <p><b>Вселенаая откуда супергерой:</b><br>
                         <input type="text" name="universe" size="40"value="<%=universe%>"class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
                     </p>
                     <p><b>Power супергероя:</b><br>
                         <input type="text" name="power" size="40"value="<%=power%>"class="w3-input w3-animate-input w3-border w3-round-larg" style="width: 30%">
                     </p>
                     <p><b>Краткое описание супергероя:</b><br>
                         <input type="text" name="description" size="40"value="<%=description%>"class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
                     </p>
                     <p><b>Супергерой жив?</b><Br>
                <%if(alive) {%>
                         <input type="radio" name="alive" value="true" checked> Да<Br>
                         <input type="radio" name="alive" value="false"> Нет<Br>
                <%}
                else{%>
                         <input type="radio" name="alive" value="true"> Да<Br>
                         <input type="radio" name="alive" value="false" checked> Нет<Br>
                <%}%>

                    </p>
                    <p><b>Номер телефона супергероя:</b><br>
                        <input type="text" name="phone" size="40"value="<%=telephone%>">
                    </p>
                    <input type="hidden" name="id" value="<%=id%>">
                    <button class="w3-btn w3-green w3-round-large w3-margin-bottom" type="submit">Submit</button>
                    </form>
                </div>
        </div>
    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button></div>
</div>
</body>
</html>
