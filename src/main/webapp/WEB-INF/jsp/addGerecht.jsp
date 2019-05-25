<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<body class="container">
<h2 class="page-header"><spring:message code="label.adddish"/></h2>
<a href="/logout" class="float-right nav-link">logout</a>
<c:if test="${errors != null}">
    <table>
        <c:forEach var="error" items="${errors}">
            <tr>
                <td>${error}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form action="/gerechten/add" method="post" modelAttribute="gerecht">
    <p>
        <label for="description"><spring:message code="label.description"/></label>
        <input id="description" name="description" type="text" value="${gerecht.description}">
    </p>
    <p>
        <label for="price"><spring:message code="label.price"/></label>
        <input id="price" name="price" value="${gerecht.price}">
    </p>
    <p>
        <label for="type"><spring:message code="label.type"/></label>
        <select id="type" name="type">
            <option value="SOEP">SOEP</option>
            <option value="DAGSCHOTEL">DAGSCHOTEL</option>
            <option value="VEGGIE">VEGGIE</option>
        </select>
    </p>
    <p>
        <input class="btn btn-info" type="submit" value="<spring:message code="label.adddish"/>">
    </p>
</form>
</body>
</html>
