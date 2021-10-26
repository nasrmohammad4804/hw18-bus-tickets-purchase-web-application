package com.example.demo.controller;

import com.example.demo.service.TicketService;
import com.example.demo.service.impl.TicketServiceImpl;
import com.example.demo.service.impl.TravelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
   private TravelServiceImpl travelService;

    @GetMapping(value = {"", "/"})
    public String homePage() {

        if (travelService.count() == 0)
            travelService.addDefaultTravel();

        return "homePage";
    }


}
