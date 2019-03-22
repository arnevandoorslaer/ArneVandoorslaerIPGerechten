<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="nl-be">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Delete Gerecht</title>
</head>
<body>
<h2>Delete Gerecht</h2>
<p>Bent u zeker dat u het gerecht ${gerecht.description} wilt verwijderen?</p>
<form action="/gerechten/delete/${gerecht.id}" method="post">
    <button type="submit">Yes</button>
</form>
<form action="/gerechten/change" method="get">
    <button type="submit">No</button>
</form>
</body>
</html>