package com.example.bookstore.controller;

import com.example.bookstore.service.FavoriteService;
import com.example.bookstore.service.impl.JAXBParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    @Autowired
    FavoriteService favoriteService;

    @RequestMapping(value = {"/shopingCart"}, method = RequestMethod.GET)
    public String handleGet(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/signin";
        }
        else {
            return "shopingCart";
        }

    }
}
