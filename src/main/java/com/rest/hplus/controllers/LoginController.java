package com.rest.hplus.controllers;

import com.rest.hplus.beans.Login;
import com.rest.hplus.beans.User;
import com.rest.hplus.exeption.ApplicationExeption;
import com.rest.hplus.repository.LoginRepository;
import com.rest.hplus.repository.UserRepository;
import com.rest.hplus.service.LoginService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;

@Controller
@SessionAttributes("login")
public class LoginController {
    @Autowired
   private LoginService loginService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login, Model model, HttpServletRequest req , HttpServletResponse res){
        try {

            User user = loginService.findByUsername(login.getUsername());

            System.out.println(user.getUsername());
            if (user != null && passwordEncoder.matches(login.getPassword(), user.getPassword())) {
                Cookie cookie = new Cookie("username", user.getUsername());
                // Set the cookie path (optional)
                cookie.setPath("/");
                // Add the cookie to the response
                res.addCookie(cookie);
//
                return "forward:/userprofile";
            } else System.out.println("in else statment");
            model.addAttribute("loginfailed", "Invalid username or password");
            return "login";
        }catch (Exception e) {throw new ApplicationExeption("user not found");}

    }
//    @ExceptionHandler(ApplicationExeption.class)
//    public String handlerException(){
//        System.out.println("in the handler exception");
//        return "error";
//    }
}
