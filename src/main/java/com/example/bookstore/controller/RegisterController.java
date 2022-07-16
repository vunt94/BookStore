package com.example.bookstore.controller;

import com.example.bookstore.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @GetMapping("register")
    public String index() {
        registerService.checkExist("0123456789");
        return "register";
    }

    @PostMapping("register")
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter(("name"));
        System.out.println(name);
    }


}
