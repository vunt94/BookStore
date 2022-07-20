package com.example.bookstore.controller;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    private ProfileService profileService;

    @GetMapping("profile")
    public String doGet () {

        return "profile";
    }

    @PostMapping("profile")
    public String doPost () {
        String userName = request.getParameter("userName");
        String phoneNumber = request.getParameter("phoneNumber");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        profileService.checkConfirmPassWord(oldPassword, newPassword);

        Accounts.Account acc = new Accounts.Account();
        return "profile";
    }
}
