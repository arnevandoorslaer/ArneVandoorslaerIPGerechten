<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="/../../css/bootstrap.css">
    <title><spring:message code="label.updatedishtitle"/></title>
</head>
<body class="container">
<h2 class="page-header"><spring:message code="label.updatedishtitle"/></h2>
<c:if test="${errors != null}">
    <table>
        <c:forEach var="error" items="${errors}">
            <tr>
                <td>${error}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form action="/gerechten/update" method="post">
    <input id="id" name="id" type="hidden" value="${gerecht.id}">
    <p>
        <label for="description"><spring:message code="label.description"/></label>
        <input id="description" name="description" type="text" value="${gerecht.description}">
    </p>
    <p>
        <label for="price"><spring:message code="label.price"/></label>
        <input id="price" name="price" value="${gerecht.price}">
    </p>
    <label for="type"><spring:message code="label.type"/></label>
    <select id="type" name="type">
        <c:forTokens items="SOEP,DAGSCHOTEL,VEGGIE" delims="," var="type">
            <p>${type}</p>
            <p>${gerecht.type}</p>
            <c:choose>
                <c:when test="${type.equals(gerecht.type)}">
                    <option selected="selected" value="${type}">${type}</option>
                </c:when>
                <c:otherwise>
                    <option value="${type}">${type}</option>
                </c:otherwise>
            </c:choose>
        </c:forTokens>
    </select>
    <p>
        <input class="btn btn-info" type="submit" value="<spring:message code="label.updatedishtitle"/>">
    </p>
</form>
</body>
</html>
