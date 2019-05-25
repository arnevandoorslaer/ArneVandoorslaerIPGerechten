<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<body class="container">
<p class="text-center alert-info"><spring:message code="errorPage"/></p>
<a class="align-content-center btn btn-dark" href="/"><spring:message code="errorPageBtn"/></a>
</body>
</html>
