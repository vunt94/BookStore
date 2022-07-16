package com.example.bookstore.service;

import com.example.bookstore.entity.Favorites;
import com.example.bookstore.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductService {
    List<Products.Product> getElementOfWishlistByPid(List<Short> listProductId);

    List<Products.Product> getAllProduct();
}
