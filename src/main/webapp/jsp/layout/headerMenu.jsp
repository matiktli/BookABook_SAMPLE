<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<body>
    <title>Spring Boot with Apache Tiles</title>
    <spring:url value="/main.css" var="mainCss" />

    <link href="${mainCss}" rel="stylesheet" />
<div class="navbar">
    <a href="/home"><spring:message code="home"   /></a>
    <a href="/books/all"><spring:message code="books"   /></a>
    <a href="/user/login"><spring:message code="login"   /></a>
    <a href="/user/register"><spring:message code="register"   /></a>
    <div class="findMenuBar"><tiles:insertAttribute name="search" flush="true"/></div>
</div>
</body>