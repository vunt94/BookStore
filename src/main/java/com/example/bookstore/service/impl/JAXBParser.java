package com.example.bookstore.service.impl;

import com.example.bookstore.Constant;
import com.example.bookstore.entity.Favorites;
import com.example.bookstore.entity.Products;

import javax.xml.bind.*;
import java.io.File;


public class JAXBParser {

    private Constant constant = new Constant();

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



}
