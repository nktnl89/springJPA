package com.epam.external.onlineShop.service.impl;

import com.epam.external.onlineShop.model.Product;
import com.epam.external.onlineShop.repository.ProductRepository;
import com.epam.external.onlineShop.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    private Gson gson = new Gson();

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.saveAndFlush(product);
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
        return receiverProduct;
    }

    @Override
    public List<Product> getProductListByJsonText(String jsonText) {
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> searchMap = gson.fromJson(jsonText, type);
        return getProductListByText(searchMap.get("search"));
    }

//    @Override
//    public int getLastProductId() {
//        Product maxIdProduct = Collections.max(productRepository.getProductList());
//        return maxIdProduct.getId();
//    }
}
