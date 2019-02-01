package com.epam.external.onlineShop.service;

import com.epam.external.onlineShop.model.Basket;
import com.epam.external.onlineShop.model.Product;
import com.epam.external.onlineShop.model.User;

import java.util.List;

public interface BasketService {
    void addProductToBasket(Basket basket, Product product);

    void deleteProductFromBasket(Basket basket, Product product);

    void issueOrder(Basket basket);

    Basket getBasketByUser(User user);

    List<Product> getProductList(Basket basket);
}
