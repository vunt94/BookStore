package com.example.bookstore.controller;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService signUpService;


    @GetMapping("signup")
    public String index() {
        return "signup";
    }

    @PostMapping("signup")
    public String doPost(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        boolean isAccountExist = signUpService.checkExist(phoneNumber);
        if(isAccountExist) {
            request.setAttribute("isPhoneNumberExist", 1);
            return "signup";
        }else {
            //create new account
            Accounts.Account newAccount = new Accounts.Account();
            int id = signUpService.getLastId() + 1;
            newAccount.setID(id);
            newAccount.setUserName(userName);
            newAccount.setPhoneNumber(phoneNumber);
            newAccount.setPassword(password);

            //write to xml
            signUpService.registerAccount(newAccount);

            //add to session
            HttpSession session = request.getSession();
            session.setAttribute("user", newAccount);
            return "redirect:/";
        }
    }


}
