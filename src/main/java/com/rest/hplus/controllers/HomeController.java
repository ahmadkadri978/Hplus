package com.rest.hplus.controllers;

import com.rest.hplus.beans.Login;
import com.rest.hplus.beans.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome(){
        System.out.println("in home controller");
        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch(){
        System.out.println("going to search page");
        return "search";
    }

    @GetMapping("/goToLogin")
    public String goToLogin(){
        System.out.println("going to login page");
        return "login";
    }
    @GetMapping("/confirmLog")
    public String confirmLog(){

        return "login";
    }


    @GetMapping("/goToRegistration")
    public String goToRegistration(){
        System.out.println("going to register page");
        return "register";
    }

//    @ModelAttribute("newuser")
//    public User getDefaultUser(){
//        return new User();
//    }
//
//    @ModelAttribute("login")
//    public Login logIn(){
//        return new Login();
//    }

 }
