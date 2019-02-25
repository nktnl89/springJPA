package com.epam.external.onlineShop.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {
        "id",
        "img",
        "text",
        "price",
        "category"},
        namespace = "http://onlineShop.external.epam.com/product")
public class Product implements Comparable<Product> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "img_src")
    @XmlElement(required = true)
    private String img;

    @Column(name = "text")
    @XmlElement(required = true)
    private String text;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_category_id")
    @XmlElement(required = true)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(int id, String img, String text, double price) {
        this.id = id;
        this.img = img;
        this.text = text;
        this.price = price;
    }

    public Product(int id, String img, String text, double price, Category category) {
        this.id = id;
        this.img = img;
        this.text = text;
        this.price = price;
        this.category = category;
    }

    public Product(String img, String text, double price) {
        this.img = img;
        this.text = text;
        this.price = price;
    }

    public Product() {
    }

    @Override
    public int compareTo(Product o) {
        if (o == null) {
            return 1;
        }
        return this.getId() - o.getId();
    }
}
