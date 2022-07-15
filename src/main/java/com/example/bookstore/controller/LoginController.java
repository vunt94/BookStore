package com.example.bookstore.controller;

import com.example.bookstore.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {

    @GetMapping("login")
    public String index() {
        return "login";
    }
}
