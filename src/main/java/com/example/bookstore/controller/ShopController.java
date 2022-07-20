package com.example.bookstore.controller;

import com.example.bookstore.entity.Products;
import com.example.bookstore.service.FavoriteService;
import com.example.bookstore.service.impl.CategoryServiceImpl;
import com.example.bookstore.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    HttpSession session;

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
    public String showShop(@RequestParam(name = "cateId", required = false) String cateId, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        HttpSession session = request.getSession();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(4);
        List<Products.Product> lstProduct = null;
        String searchName = (String) session.getAttribute("searchName");
        if (cateId == null || cateId.equals("0")) {
            lstProduct = productService.getAllProduct();
        } else {
            lstProduct = productService.getProductByCategoryID(Integer.parseInt(cateId));
        }

        List<Products.Product> lstResult = new ArrayList<Products.Product>();
        if (searchName != null && searchName != "") {
            for (int i = 0; i < lstProduct.size(); i++) {
                if (lstProduct.get(i).getName().contains(searchName)) {
                    lstResult.add(lstProduct.get(i));
                }
            }
            lstProduct = lstResult;
        } else {
            if (cateId == null || cateId.equals("0")) {
                lstProduct = productService.getAllProduct();
            } else {
                lstProduct = productService.getProductByCategoryID(Integer.parseInt(cateId));
            }
            session.removeAttribute("searchName");
        }

        Page<Products.Product> productPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize), lstProduct);

        request.setAttribute("lstProduct", productPage);

        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            request.setAttribute("pageNumbers", pageNumbers);
        }
        if (session.getAttribute("accId") != null) {
            int accId = (int) session.getAttribute("accId");
            List<Short> listPId = favoriteService.getListProductIdByAccId(accId);
            request.setAttribute("size", productService.getElementOfWishlistByPid(listPId).size());
            request.setAttribute("listPidInWishlist", listPId);
        }
        else {
            request.setAttribute("size", 0);
        }
        request.setAttribute("lstCategory", categoryService.getAllCategory());
        request.setAttribute("categoryID", cateId);

        session.setAttribute("lstProduct", lstProduct);
        session.setAttribute("categoryID", cateId);
        return "product";
    }


    @PostMapping("/search")
    public String search(@RequestParam("searchProduct") String name) {
        int currentPage = 1;
        int pageSize = 4;
        HttpSession session = request.getSession();
        String cateId = (String) session.getAttribute("categoryID");
        List<Products.Product> lst = (List<Products.Product>) session.getAttribute("lstProduct");
        if(lst == null || lst.size() <= 0){
            if (cateId == null || cateId.equals("0")) {
                lst = productService.getAllProduct();
            } else {
                lst = productService.getProductByCategoryID(Integer.parseInt(cateId));
            }
        }
        List<Products.Product> lstResult = new ArrayList<Products.Product>();
        if (name != "") {
            for (int i = 0; i < lst.size(); i++) {
                if (lst.get(i).getName().contains(name)) {
                    lstResult.add(lst.get(i));
                }
            }
        } else {

            if (cateId == null || cateId.equals("0")) {
                lst = productService.getAllProduct();
            } else {
                lst = productService.getProductByCategoryID(Integer.parseInt(cateId));
            }
            lstResult = lst;
        }
        Page<Products.Product> productPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize), lstResult);
        request.setAttribute("lstProduct", productPage);
        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            request.setAttribute("pageNumbers", pageNumbers);
        }
        // set data to wishlist
        if (session.getAttribute("accId") != null) {
            int accId = (int) session.getAttribute("accId");
            List<Short> listPId = favoriteService.getListProductIdByAccId(accId);
            request.setAttribute("size", productService.getElementOfWishlistByPid(listPId).size());
            request.setAttribute("listPidInWishlist", listPId);
        }
        else {
            request.setAttribute("size", 0);
        }
        request.setAttribute("lstCategory", categoryService.getAllCategory());
        request.setAttribute("categoryID", session.getAttribute("categoryID"));
        session.setAttribute("lstProduct", lstResult);
        session.setAttribute("searchName", name);
        return "product";
    }

    @GetMapping("/filterByPrice")
    public String filterByPrice(@RequestParam("indexPrice") String indexPrice) {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("searchName");
        List<Products.Product> lst = new ArrayList<Products.Product>();

        String cateId = (String) session.getAttribute("categoryID");
        if (cateId == null || cateId.equals("0")) {
            lst = productService.getAllProduct();
        } else {
            lst = productService.getProductByCategoryID(Integer.parseInt(cateId));
        }
        List<Products.Product> lstResult = new ArrayList<Products.Product>();
        if (name != null && name != "") {
            for (int i = 0; i < lst.size(); i++) {
                if (lst.get(i).getName().contains(name)) {
                    lstResult.add(lst.get(i));
                }
            }
        } else {
            lstResult = lst;
        }


        switch (Integer.parseInt(indexPrice)) {
            case 0:
                lstResult = lstResult;
                break;
            case 1:
                lstResult = getProductsByPrice(lstResult, Short.parseShort("0"), Short.parseShort("50"));
                break;
            case 2:
                lstResult = getProductsByPrice(lstResult, Short.parseShort("50"), Short.parseShort("100"));
                break;
            case 3:
                lstResult = getProductsByPrice(lstResult, Short.parseShort("100"), Short.parseShort("150"));
                break;
            case 4:
                lstResult = getProductsUptoPrice(lstResult, Short.parseShort("150"));
                break;
        }
        int currentPage = 1;
        int pageSize = 4;
        Page<Products.Product> productPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize), lstResult);
        request.setAttribute("lstProduct", productPage);
        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            request.setAttribute("pageNumbers", pageNumbers);
        }
        // set data to wishlist
        if (session.getAttribute("accId") != null) {
            int accId = (int) session.getAttribute("accId");
            List<Short> listPId = favoriteService.getListProductIdByAccId(accId);
            request.setAttribute("size", productService.getElementOfWishlistByPid(listPId).size());
            request.setAttribute("listPidInWishlist", listPId);
        }
        else {
            request.setAttribute("size", 0);
        }
        request.setAttribute("lstCategory", categoryService.getAllCategory());
        request.setAttribute("categoryID", session.getAttribute("categoryID"));
        session.setAttribute("lstProduct", lstResult);
        return "product";
    }

    public List<Products.Product> getProductsByPrice(List<Products.Product> lstProduct, short fromPrice, short toPrice) {
        List<Products.Product> lstResult = new ArrayList<Products.Product>();
        for (int i = 0; i < lstProduct.size(); i++) {
            if (lstProduct.get(i).getPrice() > fromPrice && lstProduct.get(i).getPrice() <= toPrice) {
                lstResult.add(lstProduct.get(i));
            }
        }
        return lstResult;
    }

    public List<Products.Product> getProductsUptoPrice(List<Products.Product> lstProduct, short fromPrice) {
        List<Products.Product> lstResult = new ArrayList<Products.Product>();
        for (int i = 0; i < lstProduct.size(); i++) {
            if (lstProduct.get(i).getPrice() > fromPrice) {
                lstResult.add(lstProduct.get(i));
            }
        }
        return lstResult;
    }

}
