<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<body>

<h1><spring:message code="book"/></h1>
<hr>


<div>
    <div class="form-group">
        <label for="titleLabel"><spring:message code="book.table.title" /></label>
        <label class="form-control" id="titleLabel">${book.title}</label>
    </div>
    <div class="form-group">
        <label for="authorLabel"><spring:message code="book.table.author"/></label>
        <label class="form-control" id="authorLabel">${book.author}</label>
    </div>
    <div class="form-group">
        <label for="typeLabel"><spring:message code="book.table.type"/></label>
        <label class="form-control" id="typeLabel">${book.type}</label>
    </div>
    <div class="form-group">
        <label for="groupLabel"><spring:message code="book.table.groups"/></label>
        <ul id="groupLabel">
            <c:forEach items="${book.groups}" var="bookGroup" >
                <li>${bookGroup}</li>
            </c:forEach>
        </ul>
    </div>
    <div class="form-group">
        <label for="statusLabel"><spring:message code="book.table.status"/></label>
        <label class="form-control" id="statusLabel">${book.status}</label>
    </div>
    <div class="form-group">
        <label for="descLabel"><spring:message code="book.table.description"/></label>
        <label class="form-control" id="descLabel">${book.description}</label>
    </div>
    <div>
        <form:form method="GET" action="/books/update/${book.id}">
            <button type="submit" class="btn btn-success"><spring:message code="book.edit"/></button>
        </form:form>
    </div>
</div>
</body>
</html>