<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><spring:message code="titleName" text="Hello"/></title>
</head>
<body>

<h1><spring:message code="greeting" /> </h1>
<h1>${currentUser.name} ${currentUser.surname}</h1>
<hr>
</body>
</html>