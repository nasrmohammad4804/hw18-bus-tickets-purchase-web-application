package com.example.demo.controller;

import com.example.demo.domain.MajorUser;
import com.example.demo.domain.Ticket;
import com.example.demo.service.impl.RegisteredUserServiceImpl;
import com.example.demo.service.impl.TicketServiceImpl;
import com.example.demo.service.impl.MajorUserServiceImpl;
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


    @Autowired
    private MajorUserServiceImpl userService;

    @Autowired
    private RegisteredUserServiceImpl userRegisteredService;


    @GetMapping(value = "/cancel-ticket")
    public String cancelTicketAlreadyPurchased(@RequestParam("ticketId") Long ticketId, HttpServletRequest request){
       Ticket ticket= ticketService.findById(ticketId).get();
        HttpSession session = request.getSession();
        if(session==null)
            return "redirect:/";

        MajorUser majorUser=(MajorUser) session.getAttribute("myUser");

      MajorUser user=  userService.findById(majorUser.getId()).get();
      user.getTicketList().remove(ticket);
      ticket.getMajorUserList().remove(user);
      int capacity= ticket.getCapacity();
      ticket.setCapacity(--capacity);
      userRegisteredService.delete(ticket.getRegisteredUser());

      return "deleteTicketPurchase";
    }
}
