package com.example.demo.controller;

import com.example.demo.service.impl.TravelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private TravelServiceImpl travelService;

    @GetMapping(value = {"", "/"})
    public String homePage(HttpServletRequest request) {

        if (travelService.count() == 0)
            travelService.addDefaultTravel();

        HttpSession session = request.getSession(false);
        if (session != null)
            return "userPanel";

        return "homePage";
    }


}
