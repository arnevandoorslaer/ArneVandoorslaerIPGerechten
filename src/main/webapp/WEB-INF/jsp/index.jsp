<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<!doctype html>
<html>
<jsp:include page="head.jsp"></jsp:include>
<body class="container">
<p><a href="/gerechten"><spring:message code="label.dishestitle"/></a></p>
<p><a href="/gerechten/change"><spring:message code="label.disheschangetitle"/></a></p>
<p><a href="/login"><spring:message code="label.login"/></a></p>
</body>
</html>
