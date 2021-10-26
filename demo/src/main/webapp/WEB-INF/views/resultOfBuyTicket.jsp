<%@ page import="com.example.demo.domain.Ticket" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .header{
            background-color: rgb(22, 160, 22);
            width: 100%;
            height: 100px;
            text-align: center;

        }
        p{
            font-size: 20px;
            color: white;
        }
    </style>
</head>
<body>
<% Ticket ticket=(Ticket) request.getAttribute("ticket");
String genderType=(ticket.getRegisteredUser().getGender().name()).equals("MEN") ? "mr" : "mrs";
String name=ticket.getRegisteredUser().getFirstName();
String family=ticket.getRegisteredUser().getLastName();
Long ticketId=ticket.getId();
%>
<div class="header" >


    <p><%=genderType%>  <%=name%> <%=family%> your ticket purchase was successful </p>
    <p>ticket id:<%=ticketId%></p>
</div>
</body>
</html>