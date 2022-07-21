package com.example.bookstore.service;

import com.example.bookstore.entity.Carts;
import com.example.bookstore.entity.Products;

import java.util.List;

public interface CartService {
    List<Carts.Cart> getCartByAccId(short accId);
    List<Products.Product> getListProductInCart(List<Short> listProductId);

    Carts.Cart getNewCartAfterUpdate(short pid, short quantity, short aid);

    List<Carts.Cart> updateMaxQuantity(short accId, List<Carts.Cart> listCart, List<Short> listProductId);

    void addProductToCart(Products.Product product, short aid, short quantity);

    boolean isProductInCart(short aid, short pid);

    void updateQuantity(short aid, short pid, short quantity);

    void deleteProductInCart(short aid, short pid);
}
