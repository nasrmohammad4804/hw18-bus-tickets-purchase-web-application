package com.example.demo.controller;

import com.example.demo.domain.MajorUser;
import com.example.demo.domain.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TicketPurchasedController {

    @Autowired
    private TicketService ticketService;

/*
    @Autowired
    private RegisteredUserService registeredUserService;
*/

    @GetMapping(value = "/tickets-purchased")
    public String showAllTicketPurchased(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        if (session == null)
            return "homePage";

        MajorUser user = (MajorUser) session.getAttribute("myUser");
        List<Ticket> ticketList = ticketService.findAllTicketByUserId(user.getId());

        if (ticketList.isEmpty())
            return "notFoundPage";

        model.addAttribute("allTickets", ticketList);
        return "allTicketPurchased";
    }

    @PostMapping(value = "/tickets-purchased")
    public String AllTicketPurchased(@RequestParam("ticket_id") Long ticketId, Model model) {


        Ticket ticket = ticketService.findWithId(ticketId);



        model.addAttribute("myTicket", ticket);
        model.addAttribute("access", LocalDateTime.now().isAfter(ticket.getTravel().getFlightDate()
                .atTime(ticket.getTravel().getTakeOfTime())) ? "no" : "yes");

        return "ticketPurchased";
    }


}
