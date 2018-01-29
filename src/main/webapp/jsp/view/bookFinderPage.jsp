<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<String> types = Arrays.asList("Author","Title"); %>

<!DOCTYPE html>

<html lang="en">
<head>
    <spring:url value="/resources/css/main.css" var="mainCss" />
    <meta charset="UTF-8">
</head>
<body>
<link href="${mainCss}" rel="stylesheet" />
    <form method="post">
        <div>
            <input type="text" name="finderInput" value="${finderInput}"/>
            <input type="submit" value= <spring:message code="find"/>/>
        </div>
    </form>
</body>
</html>