package com.mycart.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.*;
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROD_ID")
    private Long prod_id;
    @Column(name = "NAME", nullable = false, unique = false)
    private String name;
    @Column(name = "DESCRIPTION", nullable = true, unique = false)
    private String description;
    @Column(name = "PRICE", nullable = false, unique = false)
    private Double price;
    @Column(name = "STOCK", nullable = false, unique = false)
    private Integer stock;
    @Column(name = "IMAGE_URL", nullable = false, unique = false)
    private String image_url;
    @ManyToOne
    @JoinColumn(name = "CATEG_ID", referencedColumnName = "CATEG_ID")
    private Category category;
    public Product() {
    }
    public Product(Long prod_id, String name, String description, Double price, Integer stock, String image_url,
            Category category) {
        this.prod_id = prod_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image_url = image_url;
        this.category = category;
    }

    public Long getProd_id() {
        return prod_id;
    }
    public void setProd_id(Long prod_id) {
        this.prod_id = prod_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}