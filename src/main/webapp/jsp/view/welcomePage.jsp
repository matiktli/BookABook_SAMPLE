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

<h1><spring:message code="greeting" /> </h1>
<h1>${currentUser.name} ${currentUser.surname}</h1>
<hr>
</body>
</html>