package com.example.bookstore.controller;

import com.example.bookstore.entity.Categories;
import com.example.bookstore.entity.Products;
import com.example.bookstore.service.impl.CategoryServiceImpl;
import com.example.bookstore.service.impl.JAXBParser;
import com.example.bookstore.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    CategoryServiceImpl categoryService;

//    @GetMapping("/")
//    public String index(@RequestParam(name = "cateId",required = false) String cateId) {
//        if(cateId == null) {
//            request.setAttribute("lstProduct", productService.getAllProduct());
//        }else {
//            request.setAttribute("lstProduct", productService.getProductByCategoryID(Integer.parseInt(cateId)));
//        }
//        request.setAttribute("lstCategory", categoryService.getAllCategory());
//        request.setAttribute("categoryID", cateId);
//
//        return "index";
//    }

    @GetMapping("/")
    public String index(@RequestParam(name = "cateId",required = false) String cateId, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(4);
        List<Products.Product> lstProduct = null;
        if(cateId == null || cateId.equals("0")) {
            lstProduct = productService.getAllProduct();
        }else {
            lstProduct = productService.getProductByCategoryID(Integer.parseInt(cateId));
        }
        Page<Products.Product> productPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize),lstProduct);

        request.setAttribute("lstProduct", productPage);

        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            request.setAttribute("pageNumbers", pageNumbers);
        }
        request.setAttribute("lstCategory", categoryService.getAllCategory());
        request.setAttribute("categoryID", cateId);

        return "index";
    }

    @GetMapping("/product/detail/{productId}")
    public String detail(@PathVariable("productId") String productId) {
        Products.Product product = productService.getProductByID(Integer.parseInt(productId));
        request.setAttribute("productDetail", product);
        List<Products.Product> lstRelated = new ArrayList<Products.Product>();
        if(productService.getProductByCategoryID(product.getCategoryId()).size() > 8){
            lstRelated = productService.getProductByCategoryID(product.getCategoryId()).subList(0,7);
        }else {
            lstRelated = productService.getProductByCategoryID(product.getCategoryId());
        }
        for (int i = 0; i < lstRelated.size(); i++) {
            if(lstRelated.get(i).getID() == product.getID()){
                lstRelated.remove(i);
                break;
            }
        }
        request.setAttribute("lstRelated", lstRelated);
        Categories.Category category = categoryService.getCategoryByID(product.getCategoryId());
        request.setAttribute("categoryObj", category);
        return "detail";
    }
}
