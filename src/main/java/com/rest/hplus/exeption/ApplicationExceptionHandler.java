package com.rest.hplus.exeption;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

@ControllerAdvice /*This annotation makes the class accessible for all controllers in the application*/
public class ApplicationExceptionHandler {
    @ExceptionHandler({ApplicationExeption.class , AsyncRequestTimeoutException.class})
    public String handlerException(){
        System.out.println("in Global handler exception ");
        return "error";
    }
}
