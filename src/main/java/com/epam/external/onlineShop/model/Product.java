package com.epam.external.onlineShop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product implements Comparable<Product> {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name = "imgSrc")
    private String img;
    @Column(name = "text")
    private String text;
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "Category_id", nullable = false)
    private Category category;

    @ManyToMany(mappedBy = "productList")
    private List<Basket> basketList;

    @ManyToOne
    @JoinColumn(name = "Discount_id")
    private Discount discount;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    //private Discount discount;

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

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

    public Product(int id, String img, String text, int price) {
        this.id = id;
        this.img = img;
        this.text = text;
        this.price = price;
    }

    public Product(String img, String text, int price) {
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
