<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../resource/static/css/getDataFromUser.css">
</head>
<body>
<table>
    <form action="/choose-ticket" method="post">
        <tr>
            <td>firstName & lastName:</td>
            <td><input type="text" placeholder="firstName & lastName" name="fullName"></td>

        </tr>
        <tr>
            <td>gender</td>
            <td>
                <label for="women">women</label>
                <input id="women" type="radio"  name="gender" value="WOMEN" >
                <label for="men">men</label>
                <input  type="radio" name="gender" value="MEN" id="men">
                <input type="hidden" value="${travel_id}" name="travelId">
            </td>

        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" id="mySubmit" value="confirm">
            </td>
        </tr>
    </form>
</table>
</body>
</html>