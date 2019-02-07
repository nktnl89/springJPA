package com.epam.external.onlineShop.controller;

import com.epam.external.onlineShop.entity.Order;
import com.epam.external.onlineShop.entity.Product;
import com.epam.external.onlineShop.manager.UserManager;
import com.epam.external.onlineShop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserManager userManager;
    @Autowired
    private BasketService basketService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @GetMapping
    public List<Product> products() {
        return productService.getProductList();
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        product.setCategory(categoryService.getCategoryById(product.getCategory().getId()));
        productService.createProduct(product);
        return product;
    }

    @PutMapping("update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.copyPropertyValues(productService.getProductById(product.getId()), product);
    }

    @DeleteMapping("delete/{id}")
    public int deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    @PostMapping("basket/add")
    public Product addToBasket(@RequestBody int productId) {
        return basketService.addProductToBasket(productId);
    }

    @PostMapping("basket/delete")
    public Product deleteFromBasket(@RequestBody int productId) {
        basketService.deleteProductFromBasket(
                basketService.getBasketByUser(userManager.getUser()),
                productService.getProductById(productId));
        return productService.getProductById(productId);
    }

    @PostMapping("basket/issue")
    public void issueOrder() {
        orderService.issueOrder();
    }

    @PostMapping("basket")
    public List<Product> getBasketProductList() {
        return basketService.getProductList();
    }

    @PostMapping("orders")
    public List<Order> getOrderList() {
        return orderService.getOrders();
    }
}
