package com.epam.external.onlineShop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Discount")
public class Discount {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "discountPercent")
    private int discountPercent;

    @OneToMany
    private List<Product> productList;

    public Discount() {
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
