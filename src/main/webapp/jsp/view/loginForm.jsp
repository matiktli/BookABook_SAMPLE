<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>



<h1><spring:message code="user.login"/></h1>
<hr>
<!--<div class="alert alert-danger" role="alert"><strong>${error}</strong></div>-->

<form:form method="POST" action="/user/perform_login" id="logForm">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail"><spring:message code="user.form.email" /></label>
            <input type="email" class="form-control" id="inputEmail" name="email" placeholder="<spring:message code="user.form.email"  />" required autofocus>
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4"><spring:message code="user.form.password"/></label>
            <input type="password" class="form-control" name="password" id="inputPassword4" placeholder="<spring:message code="user.form.password" />" required>
        </div>
    </div>

</form:form>
<form id="noForm" method="GET" action="/user/register"></form>
<div>
    <button form="logForm" type="submit" class="btn btn-success"><spring:message code="user.login"/></button>
     <small>  /  </small>
    <button form="noForm" type="submit" class="btn btn-success"><spring:message code="user.register"/></button>

</div>
</body>
</html>