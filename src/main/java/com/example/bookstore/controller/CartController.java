package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

    @RequestMapping(value = {"/shopingCart"}, method = RequestMethod.GET)
    public String handleGet() {
        return "shopingCart";
    }
}
