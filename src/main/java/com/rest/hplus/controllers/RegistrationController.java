package com.rest.hplus.controllers;

import com.rest.hplus.beans.User;
import com.rest.hplus.repository.UserRepository;
import com.rest.hplus.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @InitBinder
    public void initBinder(WebDataBinder binder) /* to convert the date input in the page frome string to date*/ {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,"age", new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("newuser")User user, BindingResult result, Model model){
        System.out.println("in registration controller");
        System.out.println(user.getAge());
        if (result.hasErrors()){
            return "register";
        }
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userService.saveUser(user);
        model.addAttribute("dataSaved", "User registered successfully");
        return "redirect:/goToLogin";
    }
}
