<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <spring:url value="/resources/css/main.css" var="mainCss" />
    <meta charset="UTF-8">
    <title><spring:message code="titleName"/></title>
</head>
<body>
<link href="${mainCss}" rel="stylesheet" />

<h1><spring:message code="user"/></h1>
<ul>
    <li><span><spring:message code="user.form.name"/>: </span> <span><c:out value="${user.name}"/></span> </li>
    <li><span><spring:message code="user.form.surname"/>: </span> <span><c:out value="${user.surname}"/></span> </li>
    <li><span><spring:message code="user.form.email"/>: </span> <span><c:out value="${user.email}"/></span> </li>
</ul>


</body>
</html>