package com.example.bookstore.controller;

import com.example.bookstore.entity.Products;
import com.example.bookstore.service.ProductService;
import com.example.bookstore.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/addProduct")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Products.Product());
        return "createProduct";
    }

    @PostMapping("/addProduct")
    public String addNewProduct(@ModelAttribute("product") Products.Product product, RedirectAttributes redirectAttributes,
                                @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size) {
        Products.Product savedProduct = productService.createNewProduct(product);
        redirectAttributes.addFlashAttribute("savedProduct", savedProduct);
        redirectAttributes.addFlashAttribute("addProductSuccess", true);
        List<Products.Product> productList = productService.getAllProduct();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(4);
        Page<Products.Product> productPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize), productList);
        request.setAttribute("products", productPage);
        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            request.setAttribute("pageNumbers", pageNumbers);
        }
        return "managerProduct";
    }

    @GetMapping("/managerProduct")
    public String viewProductManager(@RequestParam("page") Optional<Integer> page,
                                     @RequestParam("size") Optional<Integer> size) {
        List<Products.Product> productList = productService.getAllProduct();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(4);
        Page<Products.Product> productPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize), productList);
        request.setAttribute("products", productPage);
        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            request.setAttribute("pageNumbers", pageNumbers);
        }
        return "managerProduct";
    }

    @GetMapping("/viewEditProduct/{productId}")
    public String getEditProduct(@PathVariable("productId") String productId) {
        System.out.println("here");
        Products.Product product = productService.getProductByID(Integer.parseInt(productId));
        request.setAttribute("productDetail", product);
        return "editProduct";
    }

    @PostMapping("/editProduct")
    public String editProduct(@ModelAttribute("product") Products.Product product,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {
        List<Products.Product> productList = productService.updateProduct(product);
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(4);
        Page<Products.Product> productPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize), productList);
        request.setAttribute("products", productPage);
        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            request.setAttribute("pageNumbers", pageNumbers);
        }
        return "managerProduct";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId") String productId,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {
        Products.Product product =  productService.getProductByID(Integer.parseInt(productId));
        List<Products.Product> productList = productService.deleteProduct(product);
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(4);
        Page<Products.Product> productPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize), productList);
        request.setAttribute("products", productPage);
        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            request.setAttribute("pageNumbers", pageNumbers);
        }
        return "managerProduct";
    }
}
