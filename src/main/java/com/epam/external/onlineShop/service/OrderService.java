package com.epam.external.onlineShop.service;

import com.epam.external.onlineShop.entity.Basket;
import com.epam.external.onlineShop.entity.Order;

import java.util.List;

public interface OrderService {
    void issueOrder(Basket basket);

    void issueOrder();

    List<Order> getOrders();
}
