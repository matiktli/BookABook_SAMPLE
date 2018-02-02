<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.models.enums.BookType" %>

<!DOCTYPE html>
<body>
    <h1><spring:message code="book"/></h1>
    <hr>
<form:form method="POST" action="/books/add">
    <div>
        <div class="form-group">
            <label for="inputTitle"><spring:message code="book.table.title" /></label>
            <input type="text" class="form-control is-valid" id="inputTitle" name="title" placeholder="<spring:message code="book.table.title"  />" required>
        </div>
        <div class="form-group">
            <label for="inputAuthor"><spring:message code="book.table.author" /></label>
            <input type="text" class="form-control is-valid" id="inputAuthor" name="author" placeholder="<spring:message code="book.table.author" />" required>
        </div>
        <div class="form-group">
            <label for="inputGroups"><spring:message code="book.table.groups" /></label>
            <input type="text" class="form-control is-valid" id="inputGroups" name="groups" placeholder="<spring:message code="book.table.groupsSeparate" />" required>
        </div>
        <div class="form-group">
            <label for="inputTypes"><spring:message code="book.table.type" /></label>
            <select id="inputTypes" name="type" class="form-control">
                <c:forEach items="${BookType.values()}" var="type">
                    <option value="${type}">${type}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="inputDescription"><spring:message code="book.table.description" /></label>
            <input type="text" class="form-control is-valid" id="inputDescription" name="description" placeholder="<spring:message code="book.table.description" />" required>
        </div>



    </div>
    <button type="submit" class="btn btn-success"><spring:message code="add"/></button>
</form:form>
</body>
</html>