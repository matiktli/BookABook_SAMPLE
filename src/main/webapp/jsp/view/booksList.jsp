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
    <hr>
    <table id="books" class="table table-striped">
        <thead>
            <tr>
                <th style="width: 150px;"><spring:message code="book.table.title"/></th>
                <th style="width: 100px;"><spring:message code="book.table.author"/></th>
                <th style="width: 100px;"><spring:message code="book.table.type"/></th>
                <th style="width: 200px;"><spring:message code="book.table.description"/></th>
                <th style="width: 150px;"><spring:message code="book.table.groups"/></th>
                <th style="width: 50px;"><spring:message code="book.table.status"/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${booksList}" var="book" >
                <tr>
                    <td> <a class="text-success" href="/books/find?title=${book.title}"> <c:out value="${book.title}" /></a></td>
                    <td> <a class="text-success" href="/books/find?author=${book.author}"> <c:out value="${book.author}" /></a></td>
                    <td> <a class="text-success" href="/books/find?type=${book.type}"> <c:out value="${book.type}" /></a></td>
                    <td><c:out value="${book.description}" /></td>
                    <td>
                    <c:forEach items="${book.groups}" var="bookGroup">
                        <span><a class="text-success" href="/books/find?group=${bookGroup}"><c:out value="${bookGroup}" /></a>   </span>
                    </c:forEach>
                    </td>
                    <td>
                        <c:if test="${StatusType.FREE.equals(book.status)}">
                            <form:form action="/books/booking?id=${book.id}">
                                <button type="submit" class="btn btn-success"><spring:message code="book.takeIt"/></button>
                            </form:form>
                        </c:if>
                        <c:if test="${not StatusType.FREE.equals(book.status)}">
                            ${book.status}
                        </c:if>
                    </td>

                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>