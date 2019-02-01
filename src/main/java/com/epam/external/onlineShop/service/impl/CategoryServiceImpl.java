package com.epam.external.onlineShop.service.impl;

import com.epam.external.onlineShop.model.Category;
import com.epam.external.onlineShop.repository.CategoryRepository;
import com.epam.external.onlineShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(int id) {
        return (Category) categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.saveAndFlush(category);
    }
}
