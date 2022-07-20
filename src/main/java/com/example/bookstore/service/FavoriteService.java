package com.example.bookstore.service;

import com.example.bookstore.entity.Favorites;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


public interface FavoriteService {
    void addProductToWishList(Favorites.Favorite favorite);
    Favorites deleteProductInWishlist(int productId, int accountId);

    List<Short> getListProductIdByAccId(int accId);

    void writeNewWishlistToXML(Favorites favorites);

    boolean isProductInWishlist (short productId, short accId);


}
