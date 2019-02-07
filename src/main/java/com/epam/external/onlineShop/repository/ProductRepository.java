package com.epam.external.onlineShop.repository;

import com.epam.external.onlineShop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select count(b) from Basket b join b.productList p where p.id = :productId")
    int getBasketWithProduct(@Param("productId") int id);
}
