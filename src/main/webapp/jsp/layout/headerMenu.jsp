<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<body>
    <title>Spring Boot with Apache Tiles</title>
    <spring:url value="/main.css" var="mainCss" />
    <link href="${mainCss}" rel="stylesheet" />
<div class="navbar">
    <a href="/home">Home</a>
    <a href="/books/all">Books</a>
    <a href="/books/findForBook">Search</a>
    <a href="#contact">Contact</a>
</div>
</body>