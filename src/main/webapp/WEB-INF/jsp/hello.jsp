<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <spring:url value="/resources/css/main.css" var="mainCss" />
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
<link href="${mainCss}" rel="stylesheet" />

<h1>Hello ${name}</h1>

</body>
</html>