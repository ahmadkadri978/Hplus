package com.rest.hplus.interceptors;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Code to execute before the handler method is invoked
        String sessionId = null;
        if(null!=request.getCookies()){
            for(Cookie cookie: request.getCookies()){
                if("JSESSIONID".equals((cookie.getName()))){
                    sessionId = cookie.getValue();
                }
            }
        }

        System.out.println("Incoming request data log:" + sessionId +   "at:" + new Date() + "for" + request.getRequestURI());
        return true; // Return true to continue with the handler execution, or false to stop it
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) throws Exception {
        // Code to execute after the handler method is invoked but before the view is rendered
        String sessionId = null;
        if(request.getCookies() != null) {
            for(Cookie cookie: request.getCookies()) {
                if("JSESSIONID".equals(cookie.getName())) {
                    sessionId = cookie.getValue();
                }
            }
        }
        System.out.println("In postHandle: " + sessionId);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Code to execute after the view is rendered
    }
}
