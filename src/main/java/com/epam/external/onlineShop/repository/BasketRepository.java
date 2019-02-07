package com.epam.external.onlineShop.repository;

import com.epam.external.onlineShop.entity.Basket;
import com.epam.external.onlineShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
    @Query("select b from Basket b where b.user = :user and b.isClosed = 0")
    Basket getBasketByUser(@Param("user") User user);

}
