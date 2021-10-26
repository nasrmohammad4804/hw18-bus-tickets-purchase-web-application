<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.demo.domain.Ticket" %>
<!DOCTYPE html>
<html lang="en">
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%
   List<Ticket> sortedTicketList=((List<Ticket>) request.getAttribute("allTicket")).stream().
    sorted(Comparator.comparing(Ticket::getTakeOfTime,Comparator.naturalOrder()))
    .collect(Collectors.toList());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../resource/chooseTicket.css">

</head>
<body>

<table style="border: 1px solid black;">
    <tr class="header1-table">
        <th >flighDate: <%=sortedTicketList.get(0).getFlightDate()%> </th>
        <th  colspan="2">destination: <%=sortedTicketList.get(0).getOrigin()%>-<%=sortedTicketList.get(0).getDestination()%></th>
    </tr>

    <tr class="header2-table">
        <th>travel id</th>
        <th>flight time</th>
        <th> choose</th>
    </tr>
    <c:forEach var="ticket" items="<%=sortedTicketList%>" >
        <tr>
            <td><c:out value="${ticket.travelId}"/></td>
            <c:set var="formatter" value="<%=formatter%>"/>
            <td><c:out value="${ticket.takeOfTime.format(formatter)}" /></td>
            <td> <a href="/choose-ticket?ticketId=${ticket.id}">buy</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>