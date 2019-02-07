package com.epam.external.onlineShop.service;

import com.epam.external.onlineShop.entity.Basket;
import com.epam.external.onlineShop.entity.Product;
import com.epam.external.onlineShop.entity.User;

import java.util.List;

public interface BasketService {
    void addProductToBasket(Basket basket, Product product);

    Product addProductToBasket(int productId);

    void deleteProductFromBasket(Basket basket, Product product);

    Basket getBasketByUser(User user);

    List<Product> getProductList(Basket basket);

    List<Product> getProductList();

    Basket createUserBasket(User user);
}