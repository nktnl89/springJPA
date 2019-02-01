package com.epam.external.onlineShop.repository;

import com.epam.external.onlineShop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    //Category getCategoryById(int id);

    //List<Category> getListCategory();

    //void addCategory(Category category);
}
