<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.models.enums.BookType" %>

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
    <form method="post">
        <span><spring:message code="book.table.title"/></span><input type="text" name="title" value="${book.title}"/>
        <span><spring:message code="book.table.author"/></span><input type="text" name="author" value="${book.author}"/>
        <span><spring:message code="book.table.type"/>
            <select name="type">
            <c:forEach items="${BookType.values()}" var="type">
                <option value="${type}">${type}</option>
            </c:forEach>
            </select>
        </span>
        <span><spring:message code="book.table.description"/></span><input type="text" name="description" value="${book.description}"/>
        <span><spring:message code="book.table.groups"/></span><input type="text" name="groups" value="${book.groups}"/>
        <span><spring:message code="book.table.copies"/></span><input type="number" name="copies" value="${book.copies}"/>
        <span><input type="submit" value=<spring:message code="submit"/>/></span>
    </form>
</body>
</html>