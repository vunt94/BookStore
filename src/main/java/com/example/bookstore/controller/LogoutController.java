package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping("logout")
   public String doGet(HttpServletRequest request, HttpServletResponse response) {
       Cookie[] cookies = request.getCookies();
       for (Cookie c : cookies) {
           if(c.getName().equals("phone")){
               c.setMaxAge(0);
               response.addCookie(c);
           }
           if(c.getName().equals("password")){
               c.setMaxAge(0);
               response.addCookie(c);
           }
       }
       HttpSession session = request.getSession();
       //delete account session
       session.removeAttribute("user");
       //return to home page
       return "signin";
   }
}
