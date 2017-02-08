<%--
  Created by IntelliJ IDEA.
  User: Student-25
  Date: 03.02.2017
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
    <div>
        <label>Login</label>
        <input name="login"/>
    </div>

    <div>
        <label>Password</label>
        <input type="password" name="password"/>
    </div>
    <security:csrfInput/>
    <button type="submit">Login</button>
</form>

</body>

</html>
