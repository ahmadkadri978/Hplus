package com.rest.hplus.controllers;

import com.rest.hplus.beans.Login;
import com.rest.hplus.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultAttributeController {
    @ModelAttribute("newuser")
    public User getDefaultUser(){
        return new User();
    }

    @ModelAttribute("login")
    public Login logIn(){
        return new Login();
    }
}
