package com.epam.external.onlineShop.repository;

import com.epam.external.onlineShop.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    int deleteById(int id);

    int getCountBasketWithProduct(int id);

    void updateProduct(Product product);
}
