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
    <h1><spring:message code="books"/></h1>
    <table id="books" class="tableOfBooks">
        <thead>
            <tr>
                <th style="width: 150px;"><spring:message code="book.table.title"/></th>
                <th style="width: 100px;"><spring:message code="book.table.author"/></th>
                <th style="width: 100px;"><spring:message code="book.table.type"/></th>
                <th style="width: 200px;"><spring:message code="book.table.description"/></th>
                <th style="width: 150px;"><spring:message code="book.table.groups"/></th>
                <th style="width: 50px;"><spring:message code="book.table.copies"/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${booksList}" var="book" >
                <tr>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.type}" /></td>
                    <td><c:out value="${book.description}" /></td>
                    <td><c:out value="${book.groups}" /></td>
                    <td><c:out value="${book.copies}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>