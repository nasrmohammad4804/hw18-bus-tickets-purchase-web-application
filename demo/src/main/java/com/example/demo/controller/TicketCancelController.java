package com.example.demo.controller;

import com.example.demo.domain.Ticket;
import com.example.demo.domain.Travel;
import com.example.demo.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TicketCancelController {

    @Autowired
    private TicketServiceImpl ticketService;

    @GetMapping(value = "/cancel-ticket")
    public String cancelTicketAlreadyPurchased(@RequestParam("ticketId") Long ticketId, HttpServletRequest request) {

        Ticket ticket = ticketService.findWithId(ticketId);

        HttpSession session = request.getSession();
        if (session == null)
            return "redirect:/";

        Travel travel = ticket.getTravel();
        int capacity = travel.getCapacity();
        travel.setCapacity(++capacity);
        ticketService.delete(ticket);
        return "deleteTicketPurchase";
    }
}
