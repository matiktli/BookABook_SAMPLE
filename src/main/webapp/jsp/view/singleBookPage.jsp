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

<h1><spring:message code="book"/></h1>
<ul>
    <li><span><spring:message code="book.table.title"/>: </span> <span><c:out value="${book.title}"/></span> </li>
    <li><span><spring:message code="book.table.author"/>: </span> <span><c:out value="${book.author}"/></span> </li>
    <li><span><spring:message code="book.table.type"/>: </span> <span><c:out value="${book.type}"/></span> </li>
    <li><spring:message code="book.table.groups"/></li>
        <ul>
            <c:forEach items="${book.groups}" var="bookGroup" >
                <li>${bookGroup}</li>
            </c:forEach>
        </ul>
    <li><span><spring:message code="book.table.copies"/>: </span> <span><c:out value="${book.copies}"/></span> </li>
    <li><span><spring:message code="book.table.description"/>: </span> <span><c:out value="${book.description}"/></span> </li>
</ul>


</body>
</html>