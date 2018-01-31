<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form class="form-inline my-2 my-lg-0"  method="post" action="/books/findForBook" >
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="text" name="finderInput" placeholder=<spring:message code="search"  /> >
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><spring:message code="search"  /> </button>
            </form>
    </div>
</form>
