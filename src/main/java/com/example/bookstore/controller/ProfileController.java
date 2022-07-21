package com.example.bookstore.controller;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @Autowired
    private ProfileService profileService;

    @GetMapping("profile")
    public String doGet() {
        Accounts.Account acc = (Accounts.Account) session.getAttribute("user");
        if(acc == null){
            return "signin";
        }
        String userName = acc.getUserName();
        String phone = acc.getPhoneNumber();
        request.setAttribute("userName", userName);
        request.setAttribute("phone", phone);
        return "profile";
    }

    @PostMapping("profile")
    public String doPost() {
        String userName = request.getParameter("userName");
        String phoneNumber = request.getParameter("phoneNumber");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        Accounts.Account sessionAcc = (Accounts.Account) session.getAttribute("user");
        int uid = sessionAcc.getID();

        boolean isOldPassCorrect = profileService.checkConfirmPassWord(uid, currentPassword);
        String errorMess = null;
        String successMess = null;
        if (!isOldPassCorrect) {
            errorMess = "Your current password is incorrect. Please check again!";
            request.setAttribute("errorMess", errorMess);
        } else {
            Accounts.Account acc = new Accounts.Account();
            acc.setID(uid);
            acc.setUserName(userName);
            acc.setPhoneNumber(phoneNumber);
            acc.setPassword(newPassword);
            profileService.editProfile(acc);
            successMess = "Change password successfully!";
            request.setAttribute("successMess", successMess);
        }
        return "profile";
    }
}
