<%--
  Created by IntelliJ IDEA.
  User: mebemint
  Date: 2021/08/17
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>SANDWICH CONDIMENTS</h1>
<form action="save" method="post">

    <input  type="checkbox" name="condiment" value="Lettuce">Lettuced
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment"value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <button  type="submit" value="Save">Save</button>
    <p>${message}</p>
</form>

</body>
</html>
