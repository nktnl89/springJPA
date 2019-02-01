package com.epam.external.onlineShop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {
    private String name;
    @Id
    @GeneratedValue
    private int id;
    @OneToMany()
    private List<Product> productList;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public Category(int id) {
        this.id = id;
        this.setName("Категория " + id);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Category setProductList(List<Product> productList) {
        this.productList = productList;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }
}
