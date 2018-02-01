<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>BookABook</title>
	<spring:url value="/bootstrap.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet" />
	<spring:url value="/bootsrap.js" var="mainJs" />
</head>
<body>
<div class="container"  style="margin: 0px">
	<tiles:insertAttribute name="header" />
	<div class="container" style="margin-top: 20px">
	<tiles:insertAttribute name="body" />
	</div>

</div>
</body>
<footer class="footer" style="position: absolute;
     right: 0;
     bottom: 0;
     left: 0;
     padding: 1rem;
     background-color: #efefef;
     text-align: center;">
		<tiles:insertAttribute name="footer" />

</footer>
</html>