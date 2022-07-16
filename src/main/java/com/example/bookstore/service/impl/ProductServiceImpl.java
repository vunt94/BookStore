package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Products;
import com.example.bookstore.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private JAXBParser jaxbParser = new JAXBParser();
    @Override
    public Products.Product createNewProduct(Products.Product product) {

        List<Products.Product> products = jaxbParser.getProductsByJAXB();
        product.setID((short) products.size());
        products.add(product);
        jaxbParser.writeProductToXML(new Products(products));
        return product;
    }
}
