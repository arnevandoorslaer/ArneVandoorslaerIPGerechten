<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="nl-be">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Gerecht</title>
</head>
<body>
<p>Voeg gerecht toe</p>

<c:if test="${errors != null}">
    <c:forEach var="error" items="${errors}">
        <p>${error}</p>
    </c:forEach>
</c:if>

<form action="/gerechten/add" method="post" modelAttribute="gerecht">
    <p>
        <label for="description">Beschrijving</label>
        <input id="description" name="description" type="text" value="${gerecht.description}">
    </p>
    <p>
        <label for="price">Prijs</label>
        <input id="price" name="price" value="${gerecht.price}">
    </p>
    <p>
        <label for="type">Type</label>
        <select id="type" name="type">
            <option value="SOEP">SOEP</option>
            <option value="DAGSCHOTEL">DAGSCHOTEL</option>
            <option value="VEGGIE">VEGGIE</option>
        </select>
    </p>
    <p>
        <input type="submit" value="Voeg toe">
    </p>
</form>
</body>
</html>