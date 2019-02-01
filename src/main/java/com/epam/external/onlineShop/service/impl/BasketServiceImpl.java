package com.epam.external.onlineShop.service.impl;

import com.epam.external.onlineShop.model.Basket;
import com.epam.external.onlineShop.model.Product;
import com.epam.external.onlineShop.model.User;
import com.epam.external.onlineShop.repository.BasketRepository;
import com.epam.external.onlineShop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketRepository basketRepository;

    @Override
    public void addProductToBasket(Basket basket, Product product) {
        //basketRepository.addProductToBasket(basket, product);
    }

    @Override
    public void deleteProductFromBasket(Basket basket, Product product) {
        //basketRepository.deleteProductFromBasket(basket, product);
    }

    @Override
    public void issueOrder(Basket basket) {
//        List<Product> tmpProductList = new ArrayList<>();
//        basket.setProductList(tmpProductList);
        //дальше можно уменьшать количество и тд и тп
        //можно еще ввести какой нибудь ордер, для аналитики или истории операций
    }

    @Override
    public Basket getBasketByUser(User user) {
        return null;
        //return basketRepository.getBasketByUser(user);
    }

    @Override
    public List<Product> getProductList(Basket basket) {
        return null;
        //return basketRepository.getProductList(basket);
    }
}
