package com.mycart.store.model;

public class Product {
    private Long prod_id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String image_url;
    private Long categ_id;
    public Product() {
    }
    public Product(Long prod_id, String name, String description, double price, int stock, String image_url,
            Long categ_id) {
        this.prod_id = prod_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image_url = image_url;
        this.categ_id = categ_id;
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
    public Long getCateg_id() {
        return categ_id;
    }
    public void setCateg_id(Long categ_id) {
        this.categ_id = categ_id;
    }
    
}
