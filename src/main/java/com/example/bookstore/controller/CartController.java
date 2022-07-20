package com.example.bookstore.controller;

import com.example.bookstore.entity.Carts;
import com.example.bookstore.entity.Favorites;
import com.example.bookstore.entity.Products;
import com.example.bookstore.entity.ServiceRespone;
import com.example.bookstore.service.CartService;
import com.example.bookstore.service.FavoriteService;
import com.example.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @RequestMapping(value = {"/shopingCart"}, method = RequestMethod.GET)
    public String handleGet(HttpSession session) {
        if (session.getAttribute("accId") == null) {
            return "redirect:/signin";
        }
        else {
            short accId = Short.parseShort(session.getAttribute("accId").toString());
            List<Short> listPId = favoriteService.getListProductIdByAccId(accId);
            request.setAttribute("size", productService.getElementOfWishlistByPid(listPId).size());
            List<Carts.Cart> listCart = cartService.getCartByAccId(accId);
            short totalMoney = 0;
            for (Carts.Cart cart : listCart) {
                totalMoney += cart.getPrice() * cart.getQuantity();
            }
            request.setAttribute("totalMoney", totalMoney);
            request.setAttribute("listCart", listCart);
            return "shopingCart";
        }
    }

    @PostMapping(value = "/updateCart")
    public ResponseEntity<Object> updateCart() {
        String status = "";
        short accId =Short.parseShort(session.getAttribute("accId").toString());
        String [] listId = request.getParameterValues("listId[]");
        String [] listQuantity = request.getParameterValues("listQuantity[]");
        List<Short> listIdNeedToUpdate = new ArrayList<>();
        List<Carts.Cart> listCart = new ArrayList<>();
        for (int i = 0; i < listId.length; i++) {
            short id = Short.parseShort(listId[i]);
            short quantity = Short.parseShort(listQuantity[i]);
            if (productService.getAmountOfProduct(id) < quantity) {
                listIdNeedToUpdate.add(id);
                status = "success";
            }
            else {
                Carts.Cart cart = cartService.getNewCartAfterUpdate(id, quantity, accId);
                listCart.add(cart);
            }
        }

        List<Carts.Cart> listCartAfterUpdate = cartService.updateMaxQuantity(accId, listCart, listIdNeedToUpdate);
        session.setAttribute("listCart", listCartAfterUpdate);
//        session.setAttribute("isChangeCart", true);
        ServiceRespone<List<Carts.Cart>> response = new ServiceRespone<>(status, listCartAfterUpdate);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/checkout")
    public String checkOut() {
        List<Carts.Cart> list = new ArrayList<>();
        list = (List<Carts.Cart>) session.getAttribute("listCart");


        System.out.println(list.get(0).getQuantity());
        return "index";
    }

}
