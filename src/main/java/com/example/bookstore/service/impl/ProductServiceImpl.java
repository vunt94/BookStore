package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Products;
import com.example.bookstore.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    JAXBParser jaxbParser = new JAXBParser();
    @Override
    public List<Products.Product> getAllProduct() {
        return jaxbParser.getProductsByJAXB();
    }

    @Override
    public Products.Product getProductByID(int id) {
        List<Products.Product> lstProduct = getAllProduct();
        for (int i = 0; i < lstProduct.size(); i++){
            if(lstProduct.get(i).getID() == id){
                return lstProduct.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Products.Product> getProductByCategoryID(int cateID) {
        List<Products.Product> lstProduct = getAllProduct();
        List<Products.Product> lstFilterByCateID = new ArrayList<>();
        for (int i = 0; i < lstProduct.size(); i++){
            if(lstProduct.get(i).getCategoryId() == cateID){
                lstFilterByCateID.add(lstProduct.get(i));
            }
        }
        return lstFilterByCateID;
    }

    @Override
    public Page<Products.Product> findPaginated(Pageable pageable, List<Products.Product> lstProduct) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Products.Product> list;

        if (lstProduct.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, lstProduct.size());
            list = lstProduct.subList(startItem, toIndex);
        }

        Page<Products.Product> productPage
                = new PageImpl<Products.Product>(list, PageRequest.of(currentPage, pageSize), lstProduct.size());

        return productPage;
    }

    @Override
    public List<Products.Product> getProductByName(List<Products.Product> lstProduct, String name) {
        List<Products.Product> lstFilterByName = new ArrayList<>();
        for (Products.Product product : lstProduct) {
            if (product.getName().equals(name)) {
                lstFilterByName.add(product);
            }
        }
        return lstFilterByName;
    }

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
    public Products.Product createNewProduct(Products.Product product) {

        List<Products.Product> products = jaxbParser.getProductsByJAXB();
        product.setID((short) (products.size() + 1));
        products.add(product);
        jaxbParser.writeProductToXML(new Products(products));
        return product;
    }

    @Override
    public List<Products.Product> updateProduct(Products.Product product) {
        List<Products.Product> products = jaxbParser.getProductsByJAXB();
        for(int i = 0; i < products.size(); i++) {
            Products.Product u = products.get(i);
            if(u.getID() == (product.getID())) {
                products.set(i, product);
            }
        }
        jaxbParser.writeProductToXML(new Products(products));
        return products;
    }

    @Override
    public List<Products.Product> deleteProduct(Products.Product product) {
        List<Products.Product> products = jaxbParser.getProductsByJAXB();
        for(int i = 0; i < products.size(); i++) {
            Products.Product u = products.get(i);
            if(u.getID() == (product.getID())) {
                products.remove(u);
            }
        }
        jaxbParser.writeProductToXML(new Products(products));
        return products;

    }

}
