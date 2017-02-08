<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="register_me" modelAttribute="user" method="post">
    <div>
        <label>Login</label>
        <form:input path="login"/>
    </div>

    <div>
        <label>Password</label>
        <form:password path="password"/>
    </div>
    <div>
        <label>Confirm Password</label>
        <form:password path="confirmation"/>
    </div>
    <button type="submit">Register</button>
</form:form>

</body>
</html>
