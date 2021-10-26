<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../resource/static/css/allTicketPurchased.css">
</head>
<body>

<table>

    <tr>
        <th id="first-header" colspan="3">list of purchased tickets</th>
    </tr>
    <tr id="second-header">
        <th>date</th>
        <th>ticket-id</th>
        <th>choose</th>
    </tr>

    <c:forEach var="ticket" items="${allTickets}">

        <tr>

            <form:form action="/tickets-purchased" method="post">
                <td><c:out value="${ticket.travel.flightDate}"/></td>

                <td><c:out value="${ticket.id}"/></td>
                <td><input type="submit" value="show ticket"></td>
               <input name="ticket_id" type="hidden" value="${ticket.id}">
            </form:form>
        </tr>
    </c:forEach>

</table>

</body>
</html>