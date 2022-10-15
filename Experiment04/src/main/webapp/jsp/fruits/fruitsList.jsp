<%--
  Created by IntelliJ IDEA.
  User: bian
  Date: 2022/10/13
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>水果列表</title>
</head>
<body>
    <h3>新鲜水果</h3>
    <table width="300px;" border="1">
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>产地</td>
        </tr>
        <c:forEach items="${fruitsList}" var="fruit">
            <tr>
                <td>${fruit.name}</td>
                <td>${fruit.price}</td>
                <td>${fruit.producing_area}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
