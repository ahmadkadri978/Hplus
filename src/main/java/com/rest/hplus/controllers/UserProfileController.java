package com.rest.hplus.controllers;

import com.rest.hplus.beans.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserProfileController {
    @PostMapping("/userprofile")
    public String getUserProfile(@SessionAttribute("login")Login login , Model model){
        System.out.println("in user profileController");
        System.out.println("username from session object:" + login.getUsername());
        model.addAttribute("username" , login.getUsername());
        return "profile";
    }
}
