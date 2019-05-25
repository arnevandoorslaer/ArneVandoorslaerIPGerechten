<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<!doctype html>
<html>
<jsp:include page="head.jsp"></jsp:include>
<body class="container">

<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a href="/login?lang=en">Login (English)</a>
    &nbsp;|&nbsp;
    <a href="/login?lang=fr">Login (French)</a>
    &nbsp;|&nbsp;
    <a href="/login?lang=nl">Login (Dutch)</a>
</div>
<form action="/login_succes" method="POST" class="form form-group">
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
