package com.example.demo.controller;

import com.example.demo.domain.MajorUser;
import com.example.demo.domain.RegisteredUser;
import com.example.demo.domain.Ticket;
import com.example.demo.domain.Travel;
import com.example.demo.domain.enumeration.Gender;
import com.example.demo.service.MajorUserService;
import com.example.demo.service.impl.TicketServiceImpl;
import com.example.demo.service.impl.TravelServiceImpl;
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
    TravelServiceImpl travelService;


    @GetMapping(value = "/choose-ticket")
    public String chooseTicket(@RequestParam("travelId") Long travelId, Model model) {
        model.addAttribute("travel_id", travelId);

        return "getDataFromUser";
    }

    @PostMapping("/choose-ticket")
    public String chooseTicket(@RequestParam("gender") Gender gender, @RequestParam("travelId") Long travelId, @RequestParam("fullName") String fullName, Model model, HttpServletRequest request) {

        String[] result = fullName.split(" ");

        Travel travel = travelService.findById(travelId).get();
        HttpSession session = request.getSession();
        MajorUser user =(MajorUser) session.getAttribute("myUser");


        RegisteredUser registeredUser=new RegisteredUser(result[0],result[1],gender);
        Ticket ticket=new Ticket(travel,registeredUser);
       int capacity= travel.getCapacity();
       travel.setCapacity(--capacity);
       ticket.setMajorUser(user);
       ticketService.save(ticket);

       model.addAttribute("ticket",ticket);

        return "resultOfBuyTicket";
    }
}
