<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<body class="container">
<h2 class="page-header"><spring:message code="label.deletedishtitle"/></h2>
<a href="/logout" class="float-right nav-link">logout</a>
<p>Bent u zeker dat u het gerecht ${gerecht.description} wilt verwijderen?</p>
<form action="/gerechten/delete/${gerecht.id}" method="post">
    <button class="btn btn-info" type="submit">Yes</button>
</form>
<form action="/gerechten/change" method="get">
    <button class="btn btn-info" type="submit">No</button>
</form>
</body>
</html>
