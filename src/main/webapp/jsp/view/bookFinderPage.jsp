<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<form:form class="form-inline" method="POST" action="/books/findForBook" id="finderForm">
    <input class="form-control mr-sm-2" type="text" name="finderInput" placeholder=<spring:message code="search"  />>
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" form="finderForm"><spring:message code="search"  /></button>
</form:form>