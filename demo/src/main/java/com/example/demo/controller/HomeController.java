package com.example.demo.controller;

import com.example.demo.service.TicketService;
import com.example.demo.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    TicketServiceImpl ticketService;

    @GetMapping(value = {"", "/"})
    public String homePage() {

        if (ticketService.count() == 0)
            ticketService.addDefaultTicket();

        return "homePage";
    }


}
