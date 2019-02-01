package com.epam.external.onlineShop.repository;

import com.epam.external.onlineShop.model.Basket;
import com.epam.external.onlineShop.model.Product;
import com.epam.external.onlineShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

//    void addProductToBasket(Basket basket, Product product);
//
//    void deleteProductFromBasket(Basket basket, Product product);
//
//    Basket getBasketByUser(User user);
//
//    List<Product> getProductList(Basket basket);
}
