package com.example.bookstore.controller;

import com.example.bookstore.entity.Favorites;
import com.example.bookstore.service.FavoriteService;
import com.example.bookstore.service.impl.JAXBParser;
import com.example.bookstore.service.impl.FavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.bind.JAXBException;

@Controller
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping(value = {"/addToWishlist"}, method = RequestMethod.POST)
    public String addProductToWishlist() {
        Favorites.Favorite favorite = new Favorites.Favorite();
        short pid = 5;
        short aid = 6;
        favorite.setProductId(pid);
        favorite.setAccountId(aid);
        favoriteService.addProductToWishList(favorite);
        return "redirect:/";
    }
}
