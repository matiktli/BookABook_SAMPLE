<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <spring:url value="/resources/css/main.css" var="mainCss" />
    <meta charset="UTF-8">
    <title><spring:message code="titleName"/></title>
</head>
<body>
<link href="${mainCss}" rel="stylesheet" />
    <h1><spring:message code="add"/> <spring:message code="user"/></h1>
    <form:form method="POST" action="/user/register">
        <table>
            <tr>
                <td><spring:message code="user.form.name"/></td>
                <td><input type="text" name="name" value="${user.name}"/></td>
            </tr>
            <tr>
                <td><spring:message code="user.form.surname"/></td>
                <td> <input type="text" name="surname" value="${user.surname}"/></td>
            </tr>
            <tr>
                <td><spring:message code="user.form.email"/></td>
                <td><input type="text" name="email" value="${user.email}"/></td>
            </tr>
            <tr>
                <td><spring:message code="user.form.password"/></td>
                <td><input type="text" name="password" value=""/></td>
            </tr>
            <tr>
                <td><input type="submit" value=<spring:message code="submit" /> /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>