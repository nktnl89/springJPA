package com.epam.external.onlineShop.service;

import com.epam.external.onlineShop.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();

    Product getProductById(int id);

    int deleteProduct(int id);

    void createProduct(Product product);

    List<Product> getProductListByText(String text);

    Product copyPropertyValues(Product receiverProduct, Product sourceProduct);

    void updateProduct(Product product);
}
