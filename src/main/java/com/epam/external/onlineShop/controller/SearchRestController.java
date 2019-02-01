package com.epam.external.onlineShop.controller;

import com.epam.external.onlineShop.model.Product;
import com.epam.external.onlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchRestController {
    @Autowired
    private ProductService productService;

    @PostMapping("/api/search")
    public List<Product> getSearchResult(@RequestBody String search) {
        return productService.getProductListByJsonText(search);
    }
}
