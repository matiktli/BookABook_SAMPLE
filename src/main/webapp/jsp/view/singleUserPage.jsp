<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<body>
<h1><spring:message code="user"/></h1>
<hr>
<ul>
    <li><span><spring:message code="user.form.name"/>: </span> <span><c:out value="${user.name}"/></span> </li>
    <li><span><spring:message code="user.form.surname"/>: </span> <span><c:out value="${user.surname}"/></span> </li>
    <li><span><spring:message code="user.form.email"/>: </span> <span><c:out value="${user.email}"/></span> </li>
</ul>


</body>
</html>