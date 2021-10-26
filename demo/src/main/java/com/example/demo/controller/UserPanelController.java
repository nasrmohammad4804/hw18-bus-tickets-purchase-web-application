package com.example.demo.controller;

import com.example.demo.domain.Ticket;
import com.example.demo.service.TicketService;
import com.example.demo.service.impl.MajorUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class UserPanelController {


    @Autowired
    private MajorUserServiceImpl userService;

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "user-panel")
    public String userPanel(){
        return "userPanel";
    }
    @PostMapping(value = "user-panel")
    public String userPanel(@RequestParam String origin , @RequestParam String destination, @RequestParam String date, Model model){

        LocalDate flightDate=LocalDate.parse(date);
        List<Ticket> tickets = ticketService.findAllTicketByOriginAndDestinationAndFlightDate(origin, destination, flightDate);

        if(origin.equals(destination)){
            model.addAttribute("myError","1");
            return "userPanel";
        }

        if(tickets.isEmpty())
            return "notFoundPage";

        model.addAttribute("allTicket",tickets);
        return "chooseTicket";


    }
}
