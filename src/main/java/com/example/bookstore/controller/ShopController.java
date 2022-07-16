package com.example.bookstore.controller;

import com.example.bookstore.entity.Products;
import com.example.bookstore.service.impl.CategoryServiceImpl;
import com.example.bookstore.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ShopController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    CategoryServiceImpl categoryService;

//    @GetMapping("/shop")
//    public String showShop(@RequestParam(name = "cateId",required = false) String cateId) {
//        if(cateId == null) {
//            request.setAttribute("lstProduct", productService.getAllProduct());
//        }else {
//            request.setAttribute("lstProduct", productService.getProductByCategoryID(Integer.parseInt(cateId)));
//        }
//        request.setAttribute("lstCategory", categoryService.getAllCategory());
//        request.setAttribute("categoryID", cateId);
//
//        return "product";
//    }

    @GetMapping("/shop")
    public String showShop(@RequestParam(name = "cateId",required = false) String cateId, @RequestParam("page") Optional<Integer> page,@RequestParam("size") Optional<Integer> size) {
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
        return "product";
    }
}
