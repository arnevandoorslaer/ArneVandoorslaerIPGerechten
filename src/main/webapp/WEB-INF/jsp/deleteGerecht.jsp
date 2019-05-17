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
    <title><spring:message code="label.deletedishtitle"/></title>
</head>
<body class="container">
<h2 class="page-header"><spring:message code="label.deletedishtitle"/></h2>
<p>Bent u zeker dat u het gerecht ${gerecht.description} wilt verwijderen?</p>
<form action="/gerechten/delete/${gerecht.id}" method="post">
    <button class="btn btn-info" type="submit">Yes</button>
</form>
<form action=<spring:message code="label.lang"/>/gerechten/change method="get">
    <button class="btn btn-info" type="submit">No</button>
</form>
</body>
</html>