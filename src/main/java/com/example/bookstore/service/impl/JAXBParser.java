package com.example.bookstore.service.impl;

import com.example.bookstore.Constant;
import com.example.bookstore.entity.Favorites;
import com.example.bookstore.entity.Products;

import javax.xml.bind.*;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JAXBParser {

    private Constant constant = new Constant();
    public void writeProductToFavoriteXML(Favorites.Favorite favorite) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Favorites.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Favorites favoritesCurrently =
                (Favorites) unmarshaller.unmarshal(new File("src/main/resources/xml/FavoritesTest.xml"));
        favoritesCurrently.getFavorite().add(favorite);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(favoritesCurrently, new File("src/main/resources/xml/FavoritesTest.xml"));
    }

    public void deleteProductFromFavoriteXML(int productId, int accId) {
        try {
            JAXBContext context = JAXBContext.newInstance(Favorites.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Favorites favoritesCurrently =
                    (Favorites) unmarshaller.unmarshal(new File("src/main/resources/xml/FavoritesTest.xml"));
            for (int i = 0; i < favoritesCurrently.getFavorite().size(); i++) {
                int pid = (int) favoritesCurrently.getFavorite().get(i).getProductId();
                int aid = (int)favoritesCurrently.getFavorite().get(i).getAccountId();
                if (aid == accId && productId == pid) {
                    favoritesCurrently.getFavorite().remove(i);
                    break;
                }
            }
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(favoritesCurrently, new File("src/main/resources/xml/FavoritesTest.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    public Favorites getListFavoriteFromXML() {

        try {
            JAXBContext context = JAXBContext.newInstance(Favorites.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Favorites favorites =
                    (Favorites) unmarshaller.unmarshal(new File(constant.FavoriteXMLPath));
            return favorites;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFavoriteProductToXML(Favorites favorites) {
        try {
            JAXBContext context = JAXBContext.newInstance(Favorites.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(favorites, new File(constant.FavoriteXMLPath));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Products.Product> getProductsByJAXB() {
        try {
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Products productList = (Products) unmarshaller.unmarshal(new File("src/main/resources/xml/Products.xml"));
            return productList.getProduct();
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void writeProductToXML(Products products) {
        try {
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(products, new File("src/main/resources/xml/Products.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}
