package com.example.demo.controller;

import com.example.demo.domain.MajorUser;
import com.example.demo.domain.RegisteredUser;
import com.example.demo.domain.Ticket;
import com.example.demo.domain.enumeration.Gender;
import com.example.demo.service.MajorUserService;
import com.example.demo.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TicketBuyController {

    @Autowired
    private TicketServiceImpl ticketService;

    @Autowired
    private MajorUserService majorUserService;

    @GetMapping(value = "/choose-ticket")
    public String chooseTicket(@RequestParam("ticketId") Long ticketId, Model model) {
        model.addAttribute("ticket_id", ticketId);
        return "getDataFromUser";
    }

    @PostMapping("/choose-ticket")
    public String chooseTicket(@RequestParam("gender") Gender gender, @RequestParam("ticketId") Long ticketId, @RequestParam("fullName") String fullName, Model model, HttpServletRequest request) {

        String[] result = fullName.split(" ");

        Ticket ticket = ticketService.findById(ticketId).get();
        ticket.setRegisteredUser(new RegisteredUser(result[0], result[1], gender));
        int capacity=ticket.getCapacity();
        ticket.setCapacity(--capacity);

        HttpSession session = request.getSession();




        MajorUser majorUser = (MajorUser) session.getAttribute("myUser");
        System.err.println(majorUser.getId()+"   "+majorUser.getUserName()+"   "+majorUser.getPassword()+"  "+majorUser.getFirstName()+"   "+majorUser.getLastName());
        MajorUser user= majorUserService.findById(majorUser.getId()).get();
        ticket.getMajorUserList().add(user);
        user.getTicketList().add(ticket);
        ticketService.save(ticket);

        model.addAttribute("ticketRegistered", ticket);

        return "resultOfBuyTicket";

    }
}
