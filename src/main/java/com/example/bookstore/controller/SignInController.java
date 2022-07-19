package com.example.bookstore.controller;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class SignInController {

    @Autowired
    private SignInService loginService;

    @GetMapping("signin")
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        //get cookie
        Cookie[] cookie = request.getCookies();
        String phone = "";
        String password = "";
        if (cookie != null) {
            for (Cookie c : cookie) {
                if (c.getName().equals("phone")) {
                    phone = c.getValue();
                }
                if (c.getName().equals("password")) {
                    password = c.getValue();
                }
                if (phone != null && password != null) {
                    break;
                }
            }
            if (phone != null && password != null) {//added to cookie
                Accounts.Account acc = loginService.getAccount(phone, password);
                if (acc != null) {//phone and password of account in cookie are correct(in case user change password)
                    //add to seesion
                    HttpSession session = request.getSession();

                    if (session.getAttribute("user") != null) {
                        return "index";
                    }
                    return "signin";
                } else {//incorrect phone or password -> login again
                    return "signin";
                }
            } else {//login again
                return "signin";
            }
        } else {
            return "signin";
        }
    }

    @PostMapping("signin")
    public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = request.getParameter(("phone"));
        String password = request.getParameter(("password"));
        String rememberMe = request.getParameter(("rememberMe"));
        Accounts.Account acc = loginService.getAccount(phoneNumber, password);

        boolean isLoginSuccess = loginService.login(phoneNumber, password);
        if (isLoginSuccess) {
            if (rememberMe != null) {
                Cookie cPhone = new Cookie("phone", phoneNumber);
                Cookie cPass = new Cookie("password", password);

                //set how long cookie will exist(second)
                cPhone.setMaxAge(60);
                cPass.setMaxAge(60);

                //Add to browser
                response.addCookie(cPhone);
                response.addCookie(cPass);
            }

            HttpSession session = request.getSession();
            session.setAttribute("user", acc);

            if (acc.getIsAdmin() == 1) {
                response.sendRedirect("redirect:/ManagerProduct");
            } else {
                response.sendRedirect("redirect:/home");
            }
            return "redirect:/home";
        } else {
            request.setAttribute("isLoginFail", 1);
            return "signin";
        }
    }
}
