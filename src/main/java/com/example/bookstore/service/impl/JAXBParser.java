package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Categories;
import com.example.bookstore.entity.Products;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
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
}
