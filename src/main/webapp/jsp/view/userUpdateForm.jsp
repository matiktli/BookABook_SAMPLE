<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html lang="en">

<body>
    <h1><spring:message code="user.update"/></h1>
    <hr>
    <form:form method="POST" action="/user/update/${user.id}">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4"><spring:message code="user.form.name" /></label>
            <input type="text" class="form-control" id="inputEmail4" name="name" placeholder="${user.name}" required/>
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4"><spring:message code="user.form.surname" /></label>
            <input type="text" class="form-control" id="inputSurname" name="surname" placeholder="${user.surname}" required/>
        </div>
    </div>
    <div class="form-group col-md-6">
        <label for="inputPassword4"><spring:message code="user.form.password"/></label>
        <input type="password" class="form-control" name="password" id="inputPassword4" placeholder="<spring:message code="user.form.password" />" required>
    </div>
    <button type="submit" class="btn btn-success"><spring:message code="user.update"/></button>
</form:form>
</body>
</html>