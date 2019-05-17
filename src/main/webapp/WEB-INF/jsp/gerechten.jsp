<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="/../../css/bootstrap.css">
    <title><spring:message code="label.dishestitle"/></title>
</head>
<body class="container">
<h2 class="page-header"><spring:message code="label.dishestitle"/></h2>
<c:choose>
    <c:when test="${errors != null}">
        <table>
            <c:forEach var="error" items="${errors}">
                <tr>
                    <td>${error}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <table class="table table-bordered table-striped">
            <th class="text-center"><spring:message code="label.description"/></th>
            <th class="text-center"><spring:message code="label.type"/></th>
            <th class="text-center"><spring:message code="label.price"/></th>
            <c:forEach var="gerecht" items="${gerechten}">
                <tr>
                    <td class="text-left">${gerecht.description}</td>
                    <td class="text-left">${gerecht.type}</td>
                    <td class="text-right">&euro;${gerecht.price}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
<a class="btn btn-warning" href=<spring:message code="label.lang"/>/gerechten/change><spring:message code="label.disheschangetitle"/></a>
</body>
</html>
