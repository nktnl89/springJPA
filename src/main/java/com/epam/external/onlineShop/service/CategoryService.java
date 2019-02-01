package com.epam.external.onlineShop.service;

import com.epam.external.onlineShop.model.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(int id);

    List<Category> getCategoryList();

    void addCategory(Category category);
}
