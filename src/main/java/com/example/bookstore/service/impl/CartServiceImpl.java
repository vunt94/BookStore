package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Carts;
import com.example.bookstore.entity.Products;
import com.example.bookstore.service.CartService;
import com.example.bookstore.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    private JAXBParser jaxbParser = new JAXBParser();

    private ProductService productService = new ProductServiceImpl();
    @Override
    public List<Carts.Cart> getCartByAccId(short accId) {
        List<Carts.Cart> listCart = new ArrayList<>();
        Carts carts = jaxbParser.getCartFromXML();
        for (Carts.Cart cart : carts.getCart()) {
            if (cart.getAccountId() == accId) {
                listCart.add(cart);
            }
        }
        return listCart;
    }

    @Override
    public List<Products.Product> getListProductInCart(List<Short> listProductId) {
        List<Products.Product> listProductInCart = new ArrayList<>();
        List<Products.Product> listAllProduct = productService.getAllProduct();
        ProductServiceImpl productServiceImpl = new ProductServiceImpl();
        for (Short id : listProductId) {
            listProductInCart.add(productServiceImpl.findProductByPId(id));
        }
        return listProductInCart;
    }

    @Override
    public Carts.Cart getNewCartAfterUpdate(short pid, short quantity, short aid) {
        List<Carts.Cart> listCart = getCartByAccId(aid);
        for (Carts.Cart cart : listCart) {
            if (pid == cart.getProductId()) {
                cart.setQuantity(quantity);
                return cart;
            }
        }
        return null;
    }

    @Override
    public List<Carts.Cart> updateMaxQuantity(short accId, List<Carts.Cart> listCart, List<Short> listProductId) {
        List<Carts.Cart> listCartByAid = getCartByAccId(accId);
        for (Carts.Cart cart : listCartByAid) {
            if (listProductId.contains(cart.getProductId())) {
                cart.setQuantity(productService.getAmountOfProduct(cart.getProductId()));
                listCart.add(cart);
            }
        }
        return listCart;

    }

    @Override
    public void addProductToCart(Products.Product product, short aid) {
        Carts carts = jaxbParser.getCartFromXML();
        Carts.Cart cart = new Carts.Cart();

        cart.setProductId(product.getID());
        cart.setAccountId(aid);
        cart.setImage(product.getImage());
        cart.setName(product.getName());
        cart.setPrice(product.getPrice());
//        cart.setQuantity();

        carts.getCart().add(cart);
        jaxbParser.writeCartToXML(carts);
    }

}
