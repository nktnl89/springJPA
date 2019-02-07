package com.epam.external.onlineShop.repository;

import com.epam.external.onlineShop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
