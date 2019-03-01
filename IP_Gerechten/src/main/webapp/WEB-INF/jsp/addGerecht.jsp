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

    <label for="desccription">Beschrijving</label>
    <input id="desccription" name="description" type="text" placeholder="Beschrijving">

    <label for="price">Prijs</label>
    <input id="price" name="price" type="number" placeholder="Prijs">

    <label for="type">Type</label>

    <select id="type" name="type">
            <option value="SOEP">SOEP</option>
            <option value="DAGSCHOTEL">DAGSCHOTEL</option>
            <option value="VEGGIE">VEGGIE</option>
    </select>

    <input type="submit" value="Voeg toe">
</form>
</body>
</html>