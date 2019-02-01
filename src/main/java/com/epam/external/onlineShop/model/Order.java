package com.epam.external.onlineShop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "orderDateTime")
    @NotNull
    private LocalDateTime orderDateTime;
    @ManyToOne
    @JoinColumn(name = "User_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "Basket_id", nullable = false)
    private Basket basket;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDateTime=" + orderDateTime +
                ", user=" + user +
                ", basket=" + basket +
                '}';
    }
}
