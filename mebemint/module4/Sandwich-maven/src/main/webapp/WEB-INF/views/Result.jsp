<%--
  Created by IntelliJ IDEA.
  User: mebemint
  Date: 2021/08/17
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${condiment}" var="c">
    <c:if test="${c != null}">
        <p><c:out value="${c}"/></p>
    </c:if>
</c:forEach>

</body>
</html>
