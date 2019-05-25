<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
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
<a class="btn btn-warning" href="/gerechten/change"><spring:message
        code="label.disheschangetitle"/></a>
</body>
</html>
