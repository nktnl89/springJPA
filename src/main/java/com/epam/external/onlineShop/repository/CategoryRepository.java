package com.epam.external.onlineShop.repository;

import com.epam.external.onlineShop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
