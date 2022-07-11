package com.example.bookstore.service;

import com.example.bookstore.entity.Favorites;
import org.springframework.stereotype.Service;


public interface FavoriteService {
    void addProductToWishList(Favorites.Favorite favorite);
    void deleteProductFromFavoriteXML(int productId, int accountId);
}
