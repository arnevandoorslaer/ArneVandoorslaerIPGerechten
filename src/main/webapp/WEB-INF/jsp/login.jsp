<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false"%>

<!doctype html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
<body class="container">

<form action="/login" method="POST" class="form form-group">
    <label class="control-label" for="username"><spring:message code="username"/></label>
    <input class="form-control" type="text" name="username" id="username">
    <br>
    <label class="control-label" for="password"><spring:message code="password"/></label>
    <input class="form-control" type="password" name="password" id="password">
    <br>
    <input class="btn btn-default" type="submit" name="submit" value="LOGIN">
</form>

</body>
</html>
