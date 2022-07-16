package com.example.bookstore.controller;

import com.example.bookstore.service.LoginService;
import com.example.bookstore.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;

    @GetMapping("login")
    public String index(HttpServletRequest request, HttpServletResponse response) {

        return "login";
    }

    @PostMapping("login")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = request.getParameter(("phone"));
        String password = request.getParameter(("password"));

        boolean isPhoneNumberExist = registerService.checkExist(phoneNumber);
        if (isPhoneNumberExist) {
            boolean isLoginSuccess = loginService.login(phoneNumber, password);
            if (isLoginSuccess) {
                System.out.println("success");
            } else {
                System.out.println("success");
            }
        }
        if (!isPhoneNumberExist) {
            System.out.println("phone number doesn't exist");
        }
    }
}
