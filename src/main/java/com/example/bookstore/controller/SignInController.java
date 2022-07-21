package com.example.bookstore.controller;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.FavoriteService;
import com.example.bookstore.service.ProductService;
import com.example.bookstore.service.SignInService;
import com.example.bookstore.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class SignInController {

    @Autowired
    private SignInService loginService;

    @Autowired
    private SignUpService registerService;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private ProductService productService;

    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @GetMapping("signin")
    public String doGet() {
        //get cookie
        Cookie[] cookie = request.getCookies();
        String phone = "";
        String password = "";
        if (cookie != null) {
            for (Cookie c : cookie) {
                if (c.getName().equals("phoneNumber")) {
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
    public String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phoneNumber = request.getParameter(("phoneNumber"));
        String password = request.getParameter(("password"));
        String rememberMe = request.getParameter(("rememberMe"));
        Accounts.Account acc = loginService.getAccount(phoneNumber, password);

        boolean isLoginSuccess = loginService.login(phoneNumber, password);
        if (isLoginSuccess) {
            if (rememberMe != null) {
                Cookie cPhone = new Cookie("phoneNumber", phoneNumber);
                Cookie cPass = new Cookie("password", password);

                //set how long cookie will exist(second)
                cPhone.setMaxAge(60);
                cPass.setMaxAge(60);

                //Add to browser
                response.addCookie(cPhone);
                response.addCookie(cPass);
            }

            session.setAttribute("user", acc);
            session.setAttribute("accId", acc.getID());
            if (acc.getIsAdmin() == 1) {
                return "redirect:/managerProduct";
            } else {
                return"redirect:/";
            }
        } else {
            request.setAttribute("isLoginFail", 1);
            return "signin";
        }
    }
}
