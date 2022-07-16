package com.example.bookstore.controller;

import com.example.bookstore.entity.Products;
import com.example.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Products.Product());
        return "createProduct";
    }

    @PostMapping("/addProduct")
    public String addNewProduct(@ModelAttribute("product") Products.Product product, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/addProduct", true);
        Products.Product savedProduct = productService.createNewProduct(product);
        redirectAttributes.addFlashAttribute("savedProduct", savedProduct);
        redirectAttributes.addFlashAttribute("addProductSuccess", true);
        return "redirectView";
    }

    @GetMapping("/ManagerProduct")
    public String viewProductManager(HttpServletRequest request){
        List<Products.Product> productList = productService.getAllProduct();
        request.setAttribute("products", productList);
        return "managerProduct";
    }

}
