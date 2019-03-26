<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Change Gerecht</title>
</head>
<body>
<h2>Change Gerecht</h2>
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
        <table>
            <th>Omschrijving</th>
            <c:forEach var="gerecht" items="${gerechten}">
                <tr>
                    <td>${gerecht.description}</td>
                    <td><a href="/gerechten/update/${gerecht.id}">Update</a></td>
                    <td><a href="/gerechten/delete/${gerecht.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<form action="/gerechten/add" method="get">
    <button type="submit">Voeg gerecht toe.</button>
</form>

</body>
</html>