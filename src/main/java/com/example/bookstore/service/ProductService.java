package com.example.bookstore.service;

import com.example.bookstore.entity.Products;

import java.awt.*;
import java.util.List;

public interface ProductService {
    Products.Product createNewProduct(Products.Product product);
    List<Products.Product> getAllProduct();
}
