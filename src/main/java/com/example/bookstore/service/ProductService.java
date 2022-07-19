package com.example.bookstore.service;

import com.example.bookstore.entity.Favorites;
import com.example.bookstore.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.example.bookstore.entity.Products;

import java.util.List;

import com.example.bookstore.entity.Products;

import java.awt.*;
import java.util.List;

public interface ProductService {
    List<Products.Product> getElementOfWishlistByPid(List<Short> listProductId);

    List<Products.Product> getAllProduct();

    Products.Product getProductByID(int id);

    List<Products.Product> getProductByCategoryID(int cateID);

    Products.Product createNewProduct(Products.Product product);

    List<Products.Product> updateProduct(Products.Product product);

    List<Products.Product> deleteProduct(Products.Product product);



}
