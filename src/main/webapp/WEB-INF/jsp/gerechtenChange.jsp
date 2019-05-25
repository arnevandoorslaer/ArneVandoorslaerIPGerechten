<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<body class="container">
<h2 class="page-header"><spring:message code="label.disheschangetitle"/></h2>
<a href="/logout" class="float-right nav-link">logout</a>
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
            <th>
                <form action="/gerechten/add" method="get">
                    <button class="btn btn-info btn-block" type="submit"><spring:message code="label.adddish"/></button>
                </form>
            </th>
            <c:forEach var="gerecht" items="${gerechten}">
                <tr>
                    <td>${gerecht.description}</td>
                    <td><a class="btn btn-warning btn-block"
                           href=/gerechten/update/${gerecht.id}><spring:message
                            code="label.update"/></a></td>
                    <td><a class="btn btn-danger btn-block"
                           href=/gerechten/delete/${gerecht.id}><spring:message
                            code="label.delete"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>


</body>
</html>
