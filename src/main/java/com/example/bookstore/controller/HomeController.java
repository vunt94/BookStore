package com.example.bookstore.controller;

import com.example.bookstore.service.FavoriteService;
import com.example.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final String INDEX_URL = "index";
    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index(HttpSession session, HttpServletRequest request) {
        session.setAttribute("accId", 4);
        int accId = (int) session.getAttribute("accId");
        List<Short> listPId = favoriteService.getListProductIdByAccId(accId);
        request.setAttribute("size", productService.getElementOfWishlistByPid(listPId).size());
        return INDEX_URL;
    }
}
