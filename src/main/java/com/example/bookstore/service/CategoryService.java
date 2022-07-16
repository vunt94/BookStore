package com.example.bookstore.service;

import com.example.bookstore.entity.Categories;
import com.example.bookstore.entity.Products;

import java.util.List;

public interface CategoryService {
    List<Categories.Category> getAllCategory();

    Categories.Category getCategoryByID(int id);
}
