<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<body>

    <h1><spring:message code="books"/></h1>
    <hr>
    <form:form method="GET" action="/books/add">
        <button type="submit" class="btn btn-success"><spring:message code="addBook"/></button>
    </form:form>
    <table id="books" class="table table-striped">
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
                    <td> <a href="/books/find?title=${book.title}"> <c:out value="${book.title}" /></a></td>
                    <td> <a href="/books/find?author=${book.author}"> <c:out value="${book.author}" /></a></td>
                    <td> <a href="/books/find?type=${book.type}"> <c:out value="${book.type}" /></a></td>
                    <td><c:out value="${book.description}" /></td>
                    <td>
                    <c:forEach items="${book.groups}" var="bookGroup">
                        <span><a href="/books/find?group=${bookGroup}"><c:out value="${bookGroup}" /></a>   </span>
                    </c:forEach>
                    </td>
                    <td><c:out value="${book.copies}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>