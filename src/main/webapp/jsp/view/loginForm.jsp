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
    <form:form method="POST" action="/user/login">
        <table>
            <tr>
                <td><spring:message code="user.form.email"/></td>
                <td><input type="text" name="email" value="${user.email}"/></td>
            </tr>
            <tr>
                <td><spring:message code="user.form.password"/></td>
                <td><input type="text" name="password" value=""/></td>
            </tr>
            <tr>
                <td><input type="submit" value=<spring:message code="login"/>/></td>
            </tr>

        </table>
    </form:form>
</body>
</html>