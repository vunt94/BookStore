package com.example.bookstore.service;

import com.example.bookstore.entity.Products;

import java.util.List;

public interface ProductService {
    List<Products.Product> getAllProduct();

    Products.Product getProductByID(int id);

    List<Products.Product> getProductByCategoryID(int cateID);

}
