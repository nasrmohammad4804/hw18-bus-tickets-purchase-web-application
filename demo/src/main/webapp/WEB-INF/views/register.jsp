<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../../resource/static/css/registerPage.css" rel="stylesheet">
</head>

<body>

<div class="parent">
    <div class="image">

        <div class="my-form">

            <form action="/register" method="post">
                <c:choose>
                    <c:when test="{error}!=''">
                        <div style="color: red">${error}</div>
                    </c:when>
                    <c:otherwise>
                        <div id="registeration">register page</div>
                    </c:otherwise>
                </c:choose>

                <input type="text" name="firstName" placeholder="firstName">
                <input type="text" placeholder="lastName" name="lastName">
                <input type="text" placeholder="userName" name="userName">
                <input type="password" placeholder="password" name="password">
                <input class="mySubmit" type="submit" value="login">
            </form>
        </div>
    </div>
</div>
</body>

</html>