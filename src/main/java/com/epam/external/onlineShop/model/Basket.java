package com.epam.external.onlineShop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Basket")
public class Basket {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Basket_has_Product",
            joinColumns = @JoinColumn(name = "Basket_id"),
            inverseJoinColumns = @JoinColumn(name = "Product_id"))
    private List<Product> productList;

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                '}';
    }

    public Basket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
