package com.example.bookstore.service.impl;

import com.example.bookstore.entity.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.bookstore.Constant;
import com.example.bookstore.entity.Products;

import javax.xml.bind.*;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JAXBParser {
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

    public List<Categories.Category> getCategoriesByJAXB() {
        try {
            JAXBContext context = JAXBContext.newInstance(Categories.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Categories categories = (Categories) unmarshaller.unmarshal(new File("src/main/resources/xml/Categories.xml"));
            return categories.getCategory();
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

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
                int aid = (int) favoritesCurrently.getFavorite().get(i).getAccountId();
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

    public void writeProductToXML(Products products) {
        try {
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(products, new File("src/main/resources/xml/Products.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public Accounts readListAccountFromXML() {
        try {
            JAXBContext context = JAXBContext.newInstance(Accounts.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Accounts accounts =
                    (Accounts) unmarshaller.unmarshal(new File(constant.AccountXMLPath));
            return accounts;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeAccountToXML(Accounts.Account account) {
        try {
        JAXBContext context = JAXBContext.newInstance(Accounts.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Accounts accountCurrentList =
                (Accounts) unmarshaller.unmarshal(new File(constant.AccountXMLPath));
        accountCurrentList.getAccount().add(account);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(accountCurrentList, new File(constant.AccountXMLPath));

        } catch (JAXBException e) {
            throw  new RuntimeException(e);
        }
    }

    public Products getListProductFromXML() {
        try {
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Products products =
                    (Products) unmarshaller.unmarshal(new File(constant.ProductXMLPath));
            return products;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public Carts getCartFromXML() {
        try {
            JAXBContext context = JAXBContext.newInstance(Carts.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Carts carts =
                    (Carts) unmarshaller.unmarshal(new File(constant.CartXMLPath));
            return carts;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }



}
