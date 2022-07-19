package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Favorites;
import com.example.bookstore.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    public Favorites deleteProductInWishlist(int productId, int accountId) {
        Favorites favorites = jaxbParser.getListFavoriteFromXML();
        for (int i = 0; i < favorites.getFavorite().size(); i++) {
            Favorites.Favorite favorite = favorites.getFavorite().get(i);
            int pid = (int) favorite.getProductId();
            int aid = (int) favorite.getAccountId();
            if (aid == accountId && productId == pid) {
                favorites.getFavorite().remove(i);
                break;
            }
        }
        return favorites;

    }

    @Override
    public List<Short> getListProductIdByAccId(int accId) {
        List<Short> listProductIdFavorite = new ArrayList<>();
        Favorites favoritesCurrently = jaxbParser.getListFavoriteFromXML();
        for (Favorites.Favorite favorite : favoritesCurrently.getFavorite()) {
            if ((int)favorite.getAccountId() == accId) {
                listProductIdFavorite.add(favorite.getProductId());
            }
        }
        return listProductIdFavorite;
    }

    @Override
    public void writeNewWishlistToXML(Favorites favorites) {
        jaxbParser.writeFavoriteProductToXML(favorites);
    }
}
