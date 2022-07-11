package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Favorites;
import com.example.bookstore.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    private JAXBParser jaxbParser = new JAXBParser();;
    @Override
    public void addProductToWishList(Favorites.Favorite favorite) {
        Favorites favorites = jaxbParser.getListFavoriteFromXML();
        favorites.getFavorite().add(favorite);
        jaxbParser.writeFavoriteProductToXML(favorites);
    }

    @Override
    public void deleteProductFromFavoriteXML(int productId, int accountId) {
//        jaxbParser.deleteProductFromFavoriteXML(productId, accountId);
    }
}
