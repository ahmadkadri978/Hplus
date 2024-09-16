package com.rest.hplus.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("login")
public class Logout {
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus, HttpServletResponse response , HttpServletRequest request){
        System.out.println("Ending user session" + sessionStatus);
        sessionStatus.setComplete();

        // Remove all cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }

        // Invalidate the session
        sessionStatus.setComplete();

        return "login";
    }
}
