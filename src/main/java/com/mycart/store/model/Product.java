package com.mycart.store.model;

public class Product {
    private Long prod_id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String image_url;
    private Category category;
    public Product() {
    }
    public Product(Long prod_id, String name, String description, double price, int stock, String image_url,
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
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