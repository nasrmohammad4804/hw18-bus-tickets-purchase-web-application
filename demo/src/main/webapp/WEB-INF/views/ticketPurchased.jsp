<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.demo.domain.Ticket" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../resource/static/css/ticketPurchased.css">

</head>
<body>

<table>
<%Ticket ticket =(Ticket) request.getAttribute("myTicket");%>
    <c:set var="myTicket" value='<%=ticket%>'/>
    <tr>
        <th id="first-header" colspan="2">bus ticket</th>
    </tr>
    <tr>
        <td class="bg-bedge">ticket id</td>
        <td ><%=ticket.getId()%></td>
    </tr>
    <tr>
        <td class="bg-bedge">name</td>
        <td><%=ticket.getRegisteredUser().getFirstName()%> <%=ticket.getRegisteredUser().getLastName()%></td>
    </tr>
    <tr>
        <td class="bg-bedge">gender</td>
        <td><%=ticket.getRegisteredUser().getGender().name()%></td>
    </tr>
    <tr>
        <td  class="bg-bedge">origin</td>
        <td><%=ticket.getTravel().getOrigin()%></td>
    </tr>
    <tr>
        <td  class="bg-bedge">destination</td>
        <td><%=ticket.getTravel().getDestination()%></td>
    </tr>
    <tr>
        <td  class="bg-bedge">flight-date</td>
        <td><%=ticket.getTravel().getFlightDate()%></td>
    </tr>
    <tr>
        <td  class="bg-bedge">flight-time</td>
        <td><%=ticket.getTravel().getTakeOfTime()%></td>

    </tr>
    <tr>
        <td  class="bg-bedge">travel id</td>
        <td><%=ticket.getTravel().getId()%></td>
    </tr>

    <tr>

    <c:if test="${access eq 'yes'}">
        <th colspan="2"><a id="active-link"  href="/cancel-ticket?ticketId=${myTicket.id}" >cancel ticket</a> </th>

    </c:if>
        <c:if test="${access eq 'no'}">
        <th colspan="2"><a id="disactive-link" >cancel link

            <span class="tooltip-text">this ticket not avaiable </span>
        </a></th>
        </c:if>
    </tr>
</table>

</body>
</html>