package com.epam.external.onlineShop.repository;

import com.epam.external.onlineShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //Product getProductById(int id);

    //Product getProductByText(String text);

    //List<Product> getProductList();

    //void createProduct(Product product);

    //void deleteProduct(int id);

    //int getLastProductId();
}
