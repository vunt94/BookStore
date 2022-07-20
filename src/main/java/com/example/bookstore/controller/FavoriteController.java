package com.example.bookstore.controller;

import com.example.bookstore.entity.Favorites;
import com.example.bookstore.entity.Products;
import com.example.bookstore.entity.ServiceRespone;
import com.example.bookstore.service.FavoriteService;
import com.example.bookstore.service.ProductService;
import com.example.bookstore.service.impl.JAXBParser;
import com.example.bookstore.service.impl.FavoriteServiceImpl;
import com.sun.xml.messaging.saaj.packaging.mime.internet.MimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;
import java.util.Map;

@Controller
public class FavoriteController {

    private HttpServletRequest httpServletRequest;
    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private ProductService productService;

    @GetMapping("/getWishlist")
    public ResponseEntity<Object> getAllBooks(HttpSession session) {
        int accId = (int) session.getAttribute("accId");
        List<Short> listPId = favoriteService.getListProductIdByAccId(accId);
        List<Products.Product> wishlist = productService.getElementOfWishlistByPid(listPId);
        ServiceRespone<List<Products.Product>> response = new ServiceRespone<>("success", wishlist);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("/deleteProductInWishlist")
    public ResponseEntity<Object> deleteProductInWishlist(@RequestParam(name="id") String id,
                                          HttpSession session) {

        int aid = Integer.parseInt(session.getAttribute("accId").toString()) ;
        Favorites favorites = favoriteService.deleteProductInWishlist(Integer.parseInt(id), aid);

        favoriteService.writeNewWishlistToXML(favorites);

        List<Short> listPId = favoriteService.getListProductIdByAccId(aid);
        List<Products.Product> wishlist = productService.getElementOfWishlistByPid(listPId);
        ServiceRespone<List<Products.Product>> response = new ServiceRespone<>("success", wishlist);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("/addProductToWishlist")
    public ResponseEntity<Object> addProductToWishlist(@RequestParam(name="id") String pid,
                                                          HttpSession session) {
        Favorites.Favorite favorite = new Favorites.Favorite();
        short accId = Short.parseShort(session.getAttribute("accId").toString());
        favorite.setProductId(Short.parseShort(pid));
        favorite.setAccountId(accId);

        favoriteService.addProductToWishList(favorite);

        List<Short> listPId = favoriteService.getListProductIdByAccId(accId);
        List<Products.Product> wishlist = productService.getElementOfWishlistByPid(listPId);
        ServiceRespone<List<Products.Product>> response = new ServiceRespone<>("success", wishlist);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("/checkExistProductInWishlist")
    public ResponseEntity<Object> checkExistProductInWishlist(@RequestParam(name="id") String pid,
                                                       HttpSession session) {
        String status = "";
        short accId = Short.parseShort(session.getAttribute("accId").toString());
        short productId = Short.parseShort(pid);
        boolean isInWishlist = favoriteService.isProductInWishlist(productId, accId);
        if (isInWishlist) {
            status = "success";
            Favorites favorites = favoriteService.deleteProductInWishlist((int) productId, (int) accId);
            favoriteService.writeNewWishlistToXML(favorites);
        }
        else {
            status = "fail";
            Favorites.Favorite favorite = new Favorites.Favorite();
            favorite.setProductId(productId);
            favorite.setAccountId(accId);
            favoriteService.addProductToWishList(favorite);
        }
        List<Short> listPId = favoriteService.getListProductIdByAccId(accId);
        List<Products.Product> wishlist = productService.getElementOfWishlistByPid(listPId);
        ServiceRespone<List<Products.Product>> response = new ServiceRespone<>(status, wishlist);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("/sendToLogin")
    public String sendToLogin() {
        System.out.println("here");
        return "signin";
    }


}
