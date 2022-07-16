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

    @RequestMapping(value = {"/addToWishlist"}, method = RequestMethod.POST)
    public String addProductToWishlist(@RequestParam Map<String, String> map,
                                       HttpServletRequest request) {
        Favorites.Favorite favorite = new Favorites.Favorite();
        short pid = 10;
        short aid = 4;
        String url = map.get("url");
        favorite.setProductId(pid);
        favorite.setAccountId(aid);
        System.out.println("Add product to wishlist: " + url);
        favoriteService.addProductToWishList(favorite);
        List<Short> listPId = favoriteService.getListProductIdByAccId(aid);
        request.setAttribute("wishlist", productService.getElementOfWishlistByPid(listPId));
        return url;
    }

//    @RequestMapping(value = {"/deleteProduct"}, method = RequestMethod.POST)
//    public String deleteProductInWishlist(@RequestParam Map<String, String> map,
//                                          HttpSession session,
//                                          HttpServletRequest request) throws IOException {
//        int pid = Integer.parseInt(map.get("id"));
//        String url = map.get("url");
//        int aid = (int) session.getAttribute("accId");
//        Favorites favorites = favoriteService.deleteProductInWishlist(pid, aid);
//        favoriteService.writeNewWishlistToXML(favorites);
//        List<Short> listPId = favoriteService.getListProductIdByAccId(aid);
//        request.setAttribute("wishlist", productService.getElementOfWishlistByPid(listPId));
//        request.setAttribute("isDisplayWishlist", true);
//        return url;
//    }

    @RequestMapping(value = {"/deleteProduct"}, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProductInWishlist(@RequestParam Map<String, String> map,
                                          HttpSession session,
                                          HttpServletRequest request) throws IOException {
        int pid = Integer.parseInt(map.get("id"));
        String url = map.get("url");
        int aid = (int) session.getAttribute("accId");
        Favorites favorites = favoriteService.deleteProductInWishlist(pid, aid);
        favoriteService.writeNewWishlistToXML(favorites);
        List<Short> listPId = favoriteService.getListProductIdByAccId(aid);
        request.setAttribute("wishlist", productService.getElementOfWishlistByPid(listPId));
        request.setAttribute("isDisplayWishlist", true);
    }

    @RequestMapping(value = {"/showWishlist"}, method = RequestMethod.POST)
    public String showWishlist(ModelMap modelMap, HttpSession session) {
        session.setAttribute("accId", 4);
        int accId = (int) session.getAttribute("accId");
        List<Short> listPId = favoriteService.getListProductIdByAccId(accId);
        modelMap.addAttribute("wishlist", productService.getElementOfWishlistByPid(listPId));
        return "forward:/";
    }

    @GetMapping("/getWishlist")
    public ResponseEntity<Object> getAllBooks(HttpSession session) {
        int accId = (int) session.getAttribute("accId");
        List<Short> listPId = favoriteService.getListProductIdByAccId(accId);
        List<Products.Product> wishlist = productService.getElementOfWishlistByPid(listPId);
        ServiceRespone<List<Products.Product>> response = new ServiceRespone<>("success", wishlist);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
