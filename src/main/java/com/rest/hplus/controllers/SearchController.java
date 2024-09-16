package com.rest.hplus.controllers;

import com.rest.hplus.beans.Product;
import com.rest.hplus.repository.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/search") // Callable allows for asynchronous processing of the request.
    public Callable<String> search(@RequestParam("search") String search, Model model , HttpServletRequest req){
        System.out.println("in search controller");
        System.out.println("search criteria: "+search);
        System.out.println("Async supported in application: " + req.isAsyncSupported());
        System.out.println("Thread from the servlet controller:" +Thread.currentThread().getName()); // request processing Thread
        return ()->{ //This is a lambda expression that returns a Callable object.
            try {
                Thread.sleep(4000); //simulating the delay that happens in blocking calls Thread layer
            } catch (InterruptedException e) {
                // Handle interruption if needed
                e.printStackTrace();
            }
            System.out.println("Thread from the spring mvc task executer :" +Thread.currentThread().getName()); // blocking calls processing Thread
            List<Product> products = new ArrayList<>();
            System.out.println(products);
            products = productRepository.searchByName(search);
            model.addAttribute("products", products);
            return "search";

        };


    }

}
