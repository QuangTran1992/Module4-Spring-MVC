<%--
  Created by IntelliJ IDEA.
  User: mebemint
  Date: 2021/08/18
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="caculator" method="post">

    <div>
        <input placeholder="num1" type="text" name="number1">

        <input placeholder="num2" type="text" name="number2">
    </div>

<div>
    <button name="cal" type="submit" value="+">Cong</button>
    <button name="cal" type="submit" value="-">Tru</button>
    <button name="cal" type="submit" value="*">Nhan</button>
    <button name="cal" type="submit" value="/">Chia</button>
</div>
<p>Result:${result}</p>
    <p>Message : ${message}</p>

</form>
</body>
</html>
