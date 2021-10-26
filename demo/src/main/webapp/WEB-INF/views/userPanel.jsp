<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../resource/userPanel.css">
</head>
<body>

<a href="/tickets-purchased">show ticket list purchase</a>
<div class="parent">

    <form  action="/user-panel" method="post" >

        <input class="travel" list="cities1" name="origin" placeholder="please enter your origin" required>
        <datalist id="cities1">

            <option value="tehran">tehran</option>
            <option value="mashhad">mashhad</option>
            <option value="karaj">karaj</option>
            <option value="isfahan">isfahan</option>
            <option value="shiraz">shiraz</option>
            <option value="qom">qom</option>
            <option value="kerman">kerman</option>
            <option value="tabriz">tabriz</option>
            <option value="semnan">semnan</option>
            <option value="yazd">yazd</option>
            <option value="gheshm">gheshm</option>
            <option value="kish">kish</option>
            <option value="ardebil">ardebil</option>
            <option value="yasooj">yasooj</option>
        </datalist>



        <input class="travel" list="cities2" name="destination" placeholder="please enter your destination" required>
        <datalist id="cities2">

            <option value="tehran">tehran</option>
            <option value="mashhad">mashhad</option>
            <option value="karaj">karaj</option>
            <option value="isfahan">isfahan</option>
            <option value="shiraz">shiraz</option>
            <option value="qom">qom</option>
            <option value="kerman">kerman</option>
            <option value="tabriz">tabriz</option>
            <option value="semnan">semnan</option>
            <option value="yazd">yazd</option>
            <option value="gheshm">gheshm</option>
            <option value="kish">kish</option>
            <option value="ardebil">ardebil</option>
            <option value="yasooj">yasooj</option>
        </datalist>


        <input type="date" name="date" placeholder="date" >


        <input type="submit" id="mySubmit" value="search flight">
    </form>
    <c:if test="${myError eq '1'}">
        <p style="color: red; text-align: center; font-size: 18px;">you musunt have equal origin and destination</p>
    </c:if>
</div>
</body>
</html>