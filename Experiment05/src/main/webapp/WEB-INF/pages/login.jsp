<%--
  Created by IntelliJ IDEA.
  User: bian
  Date: 2022/10/18
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>登陆</title>
    <link href="${pageContext.request.contextPath}/css/regcss.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript">
        function validate() {
            if(document.getElementById("username").value=="") {
                alert("用户名不能为空");
                document.getElementById("username").focus();
                return false;
            } else if(document.getElementById("password").value=="") {
                alert("密码不能为空");
                document.getElementById("password").focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <div id="content">
        <div id="form">
            <h1>用户登录</h1>
            <form action="/user/login" method="post" id="myform" onsubmit="return validate()">
                用户名<input type="text" id="username" name="userName" style="width: 190px; height: 26px; margin-left: 39px"/><br/>
                密码<input type="password" id="password" name="password" style="width: 190px; height: 26px; margin-top: 8px; margin-left: 54px"/><br/>
                <input type="submit" value="登陆" style="width: 50px; height: 30px; margin-top: 8px"/>
                <a href="registerPage.jsp">注册</a>
            </form>
            <!-- 显示错误信息 -->
            <c:if test="${errorMsg!=null}">
                <span style="color: red; ">${errorMsg}</span>
            </c:if>
            <!-- 显示提示 -->
            <c:if test="${noticeMsg!=null}">
                <span style="color: green; ">${noticeMsg}</span>
            </c:if>
        </div>
    </div>
</body>
</html>
