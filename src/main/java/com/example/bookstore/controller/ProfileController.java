package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    HttpServletRequest request;



    @GetMapping("profile")
    public String doGet () {
        return "profile";
    }

    @PostMapping("profile")
    public String doPost () {
        String fullName = request.getParameter("fullName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        return "profile";
    }
}
