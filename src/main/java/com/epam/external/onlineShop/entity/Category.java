package com.epam.external.onlineShop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "category", propOrder = {
        "id",
        "name"},
        namespace = "http://onlineShop.external.epam.com/category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    @Column(name = "name")
    @XmlElement(required = true)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<>();

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

    @JsonIgnore
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
