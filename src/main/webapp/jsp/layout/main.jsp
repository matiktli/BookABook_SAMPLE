<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>BookABook</title>
	<spring:url value="/bootstrap.min.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet" />
</head>
<body>
<div class="container" style="margin: 50px">
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</div>
</body>
</html>