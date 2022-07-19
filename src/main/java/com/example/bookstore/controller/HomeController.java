package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("home")
    public String index(HttpServletRequest request) {
        HttpSession accountSession = request.getSession();
        request.setAttribute("accountSession", accountSession.getAttribute("user"));
        return "index";
    }
}
