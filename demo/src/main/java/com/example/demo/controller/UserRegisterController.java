package com.example.demo.controller;

import com.example.demo.domain.MajorUser;
import com.example.demo.service.impl.MajorUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserRegisterController {

    private MajorUserServiceImpl userService;

    @Autowired
    public UserRegisterController(MajorUserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerValidation( @ModelAttribute("majorUser") MajorUser majorUser , Model model, HttpServletRequest request) {
        Optional<MajorUser> userOptional = userService.findUserByUserName(majorUser.getUserName());

        if(userOptional.isPresent()){
            model.addAttribute("error","this userName already exists");
            return "redirect:/register";
        }

      userService.save(majorUser);
        HttpSession session = request.getSession();
        session.setAttribute("myUser",majorUser);
        return "userPanel";
    }
}
