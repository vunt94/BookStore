package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Categories;
import com.example.bookstore.entity.Products;
import com.example.bookstore.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    JAXBParser jaxbParser = new JAXBParser();
    @Override
    public List<Categories.Category> getAllCategory() {
        return jaxbParser.getCategoriesByJAXB();
    }

    @Override
    public Categories.Category getCategoryByID(int id) {
        List<Categories.Category> lstCategory = getAllCategory();
        for (int i = 0; i < lstCategory.size(); i++){
            if(lstCategory.get(i).getID() == id){
                return lstCategory.get(i);
            }
        }
        return null;
    }
}
