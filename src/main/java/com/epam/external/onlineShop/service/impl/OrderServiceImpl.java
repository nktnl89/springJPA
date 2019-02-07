package com.epam.external.onlineShop.service.impl;

import com.epam.external.onlineShop.entity.Basket;
import com.epam.external.onlineShop.entity.Order;
import com.epam.external.onlineShop.entity.User;
import com.epam.external.onlineShop.manager.UserManager;
import com.epam.external.onlineShop.repository.OrderRepository;
import com.epam.external.onlineShop.service.BasketService;
import com.epam.external.onlineShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserManager userManager;
    @Autowired
    private BasketService basketService;
    @Value("${DISCOUNTPERCENT}")
    private int DISCOUNTPERCENT;


    @Override
    public void issueOrder(Basket basket) {
        Order order = new Order();
        basket.setClosed(true);

        AtomicReference<Double> sum = new AtomicReference<>((double) 0);
        AtomicReference<Double> discountSum = new AtomicReference<>((double) 0);
        basket.getProductList().forEach(product -> {
            sum.updateAndGet(v -> (double)(v + product.getPrice()));
            discountSum.updateAndGet(v -> (double) (v + product.getPrice() / 100 * DISCOUNTPERCENT));
        });
        basket.setSum(sum.get());
        basket.setDiscountSum(discountSum.get());
        order.setOrderDateTime(LocalDateTime.now());
        order.setBasket(basket);

        orderRepository.save(order);
    }

    @Override
    public void issueOrder() {
        User currentUser = userManager.getUser();
        if (currentUser != null) {
            Basket currentBasket = basketService.getBasketByUser(currentUser);
            issueOrder(currentBasket);
        }
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
