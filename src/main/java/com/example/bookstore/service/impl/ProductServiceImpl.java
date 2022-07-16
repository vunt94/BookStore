package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Favorites;
import com.example.bookstore.entity.Products;
import com.example.bookstore.service.FavoriteService;
import com.example.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private JAXBParser jaxbParser = new JAXBParser();

    @Autowired
    FavoriteService favoriteService;

    @Override
    public List<Products.Product> getElementOfWishlistByPid(List<Short> listProductId) {
        List<Products.Product> listProductInWishlist = new ArrayList<>();
        List<Products.Product> listAllProduct = getAllProduct();
        for (Products.Product product : listAllProduct) {
            if ( listProductId.contains(product.getID())) {
                listProductInWishlist.add(product);
            }
        }
        return listProductInWishlist;
    }

    @Override
    public List<Products.Product> getAllProduct() {
        return jaxbParser.getListProductFromXML().getProduct();
    }
}
