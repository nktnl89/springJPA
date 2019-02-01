package com.epam.external.onlineShop.service;

import com.epam.external.onlineShop.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getProductList();

    Product getProductById(int id);

    void deleteProduct(int id);

    void createProduct(Product product);

    List<Product> getProductListByText(String text);

    Product copyPropertyValues(Product receiverProduct, Product sourceProduct);

    List<Product> getProductListByJsonText(String jsonText);

    //int getLastProductId();
}
