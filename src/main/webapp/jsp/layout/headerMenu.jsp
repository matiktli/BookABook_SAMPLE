<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-inverse bg-inverse">

        <div class="row">
            <div class="col-sm">
                <button class="btn btn-outline-success" onclick="location.href='/home'">
                    <spring:message code="home"/>
                </button>
            </div>
            <div class="col-sm">
                <button class="btn btn-outline-success" onclick="location.href='/books/all'">
                    <spring:message code="books"/>
                </button>
            </div>
            <div class="col-sm form-inline">
                <c:if test="${empty currentUser}">
                    <button class="btn btn-outline-success" onclick="location.href='/user/perform_login'">
                        <spring:message code="login"/>
                    </button>
                </c:if>
                <c:if  test="${not empty currentUser}">
                    <button class="btn btn-outline-success" onclick="location.href='/user/find?email=${currentUser.email}'">
                        ${currentUser.name}
                    </button>

                </c:if>
            </div>
            <c:if  test="${not empty currentUser}">

                <div class="col-sm">
                    <form:form id="logout" action="/logout">
                        <button class="btn btn-outline-success" type="submit" form="logout"><spring:message code="user.logout"/></button>
                    </form:form>
                </div>
            </c:if>

            <div class="col-sm">
                <form:form method="POST" action="/books/findForBook" id="finderForm">
                    <input class="form-control" type="text" name="finderInput" placeholder=<spring:message code="search"  />>
                </form:form>
            </div>
            <div class="col-sm">
                <button class="btn btn-outline-success" type="submit" form="finderForm"><spring:message code="search"  /></button>
            </div>
            <div class="col-sm">
                <img src="http://www.emmebiesse.net/wp-content/uploads/2008/03/icon.png" width="40" height="40" onclick="location.href='/home?lang=en'"/>
                <img src="https://cdn3.iconfinder.com/data/icons/flags-circle/100/Poland-512.png" width="40" height="40" onclick="location.href='/home?lang=pl'"/>
            </div>

        </div>
</nav>



