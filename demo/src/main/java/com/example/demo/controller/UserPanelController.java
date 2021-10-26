package com.example.demo.controller;

import com.example.demo.domain.Travel;
import com.example.demo.service.TravelService;
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
    private TravelService travelService;

    @GetMapping(value = "user-panel")
    public String userPanel(){
        return "userPanel";
    }
    @PostMapping(value = "user-panel")
    public String userPanel(@RequestParam String origin , @RequestParam String destination, @RequestParam String date, Model model) {

        LocalDate flightDate = LocalDate.parse(date);
        List<Travel> travels = travelService.findAllTravelByOriginAndDestinationAndFlightDate(origin, destination, flightDate);

        if (origin.equals(destination)) {
            model.addAttribute("myError", "1");
            return "userPanel";
        }

        if (travels.isEmpty())
            return "notFoundPage";

        model.addAttribute("allTravel", travels);
        return "chooseTicket";
    }
}
