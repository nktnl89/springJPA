package com.epam.external.onlineShop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "User_id", nullable = false)
    private User user;

    @Column(name = "is_closed")
    private boolean isClosed;

    @Column(name = "discount_sum")
    private double discountSum;

    @Column(name = "sum")
    private double sum;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "basket_has_product",
            joinColumns = @JoinColumn(name = "basket_basket_id", referencedColumnName = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_product_id", referencedColumnName = "product_id"))
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void deleteProduct(Product product) {
        productList.remove(product);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public double getDiscountSum() {
        return discountSum;
    }

    public void setDiscountSum(double discountSum) {
        this.discountSum = discountSum;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                '}';
    }

    public Basket(User user) {
        this.user = user;
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
