<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
<form:form class="form-inline my-2 my-lg-0" method="POST" id="finder" action="/books/findForBook">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <form:form class="form-inline my-2 my-lg-0"  >
                <input class="form-control mr-sm-2" type="text" name="finderInput" placeholder=<spring:message code="search"  /> >
                <button class="btn btn-outline-success my-2 my-sm-0" form="finder" type="submit"><spring:message code="search"  /> </button>
            </form:form>
    </div>
</form:form>
</body>