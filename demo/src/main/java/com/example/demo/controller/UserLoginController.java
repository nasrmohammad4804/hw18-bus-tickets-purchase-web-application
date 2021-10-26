package com.example.demo.controller;

import com.example.demo.domain.MajorUser;
import com.example.demo.service.impl.MajorUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserLoginController {

    @Autowired
   private MajorUserServiceImpl userService;

    @GetMapping("/login")
    public String login(MajorUser majorUser){
        return "login";
    }
    @PostMapping(value = "/login")
    public String loginValidation(@Valid @ModelAttribute("majorUser") MajorUser majorUser, BindingResult bindingResult, Model model, HttpServletRequest request){

        if(bindingResult.hasErrors())
            return "login";

        Optional<MajorUser> userOptional = userService.findUserByUserName(majorUser.getUserName());

        if(userOptional.isEmpty()){
            model.addAttribute("userNameError","1");
            return "login";
        }
        else if( !userOptional.get().getPassword().equals(majorUser.getPassword())){
            model.addAttribute("passwordError","2");
            return "login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("myUser",userOptional.get());
        return "userPanel";
    }
}
