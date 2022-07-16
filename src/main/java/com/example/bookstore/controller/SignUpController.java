package com.example.bookstore.controller;

import com.example.bookstore.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService registerService;
    @GetMapping("signup")
    public String index() {
        registerService.checkExist("0123456789");
        return "signup";
    }

    @PostMapping("signup")
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter(("name"));
        System.out.println(name);
    }


}
