package com.epam.external.onlineShop.service.impl;

import com.epam.external.onlineShop.entity.Product;
import com.epam.external.onlineShop.repository.ProductRepository;
import com.epam.external.onlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public int deleteProduct(int id) {
        if (productRepository.getBasketWithProduct(id) > 0) {
            return -1;
            //    throw new CannotDeleteProductException("С этим товаром есть заказы, удаление невозможно");
        }
        productRepository.deleteById(id);
        return id;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getProductListByText(String text) {
        List<Product> result = new ArrayList<>();

        productRepository.findAll().forEach(product -> {
            if (product.getText().contains(text)) {
                result.add(product);
            }
        });
        return result;
    }

    @Override
    public Product copyPropertyValues(Product receiverProduct, Product sourceProduct) {
        receiverProduct.setText(sourceProduct.getText());
        receiverProduct.setPrice(sourceProduct.getPrice());
        receiverProduct.setImg(sourceProduct.getImg());
        productRepository.save(receiverProduct);
        return receiverProduct;
    }
}
