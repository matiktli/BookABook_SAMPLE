<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>


<body>
<h1><spring:message code="user.login"/></h1>
<hr>
<link href="${mainCss}" rel="stylesheet" />
<form:form method="POST" action="/user/login">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail"><spring:message code="user.form.email" /></label>
            <input type="email" class="form-control" id="inputEmail" name="email" placeholder="<spring:message code="user.form.email"  />">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4"><spring:message code="user.form.password"/></label>
            <input type="password" class="form-control" name="password" id="inputPassword4" placeholder="<spring:message code="user.form.password" />">
        </div>
    </div>
    <button type="submit" class="btn btn-success"><spring:message code="user.login"/></button>
</form:form>
</body>
</html>