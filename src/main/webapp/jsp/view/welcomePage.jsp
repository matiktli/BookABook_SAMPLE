<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <spring:url value="/resources/css/main.css" var="mainCss" />
    <meta charset="UTF-8">
    <title><spring:message code="titleName" text="Hello"/></title>
</head>
<body>
<link href="${mainCss}" rel="stylesheet" />

<h1><spring:message code="greeting" text="Greetings my friend"/></h1>
<hr>
</body>
</html>