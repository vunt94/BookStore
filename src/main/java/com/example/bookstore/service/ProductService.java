package com.example.bookstore.service;

import com.example.bookstore.entity.Products;

public interface ProductService {
    Products.Product createNewProduct(Products.Product product);
}
