package com.example.bookstore.controller;

import com.example.bookstore.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    private RegisterService registerService;
    @GetMapping("register")
    public String index() {
        registerService.checkExist("0000000");
        return "register";
    }


}
