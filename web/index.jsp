<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 16.11.2018
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="keywords" content="test, site, website" />
  <meta name="description" content="Этот сайт является пробным сайтом" />
  <link href="css/style.css" rel="stylesheet" type="text/css" />
  <link href="image/icon.ico" rel="shortcut icon" type="image/x-icon" />
  <title>background-image</title>
  <style>
    body {
      background: #cccc;
      background-image:url(images/background_image.jpg);
      background-size:cover;

    }

  </style>

</head>
<body>
<h1> <hline>Super Hero</hline></h1>
<im>
  <div style="float: left;">
    <a class="feed-link"  onclick="location.href='/list?alive=false'" >
      <img alt="lost" border="o" src="https://f.vividscreen.info/soft/0ecac4bc4dd27b570f701a452f67fed1/Avengers-2-Age-of-Ultron-wide-l.jpg" title="Рис.1"width="300" height="200" /></a>
  </div>
  <div style="float: left;">
    <a class="feed-link"  onclick="location.href='/list?alive=true'">
      <img alt="surviving" border="o" src="https://www.desktopbackground.org/t/2014/10/15/840584_marvel-the-avengers-age-of-ultron-2015-movie-promo-avengers_1429x893_h.jpg" title="Рис.1"width="300" height="200" /></a>
  </div>
</im>



</body>
</html>
