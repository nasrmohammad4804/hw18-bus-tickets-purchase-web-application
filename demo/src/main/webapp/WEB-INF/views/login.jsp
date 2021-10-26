<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../resource/static/css/loginPage.css">

</head>
<body>

<div class="parent">

    <div class="image">

        <div class="parent-form">

            <form:form method="post" modelAttribute="majorUser" action="/login" id="my-form" >
                <div>login page</div>
                <form:input path="userName" type="text" placeholder="userName"/> <br>
                <span >  <form:errors cssStyle="color: red" path="userName"/>  </span>
               <c:if test="${userNameError eq '1'}"> <span style="color:red;">this userName not exists</span> </c:if>
                <form:input path="password" type="password" placeholder="password"/> <br>
                <span ><form:errors cssStyle="color: red" path="password"/> </span>
                <c:if test="${passwordError eq '2'}"><span style="color:red">this password is wrong</span></c:if>
                <input class="mySubmit"  type="submit" value="login" >
            </form:form>

        </div>
    </div>
</div>
</body>
</html>