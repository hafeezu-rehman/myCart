package com.mycart.store.model;

public class OrderItem {
    private Long ord_item_id;
    private int quantity;
    private double price;
    private Long prod_id;
    private Long ord_id;
    public OrderItem() {
    }
    public OrderItem(Long ord_item_id, int quantity, double price, Long prod_id, Long ord_id) {
        this.ord_item_id = ord_item_id;
        this.quantity = quantity;
        this.price = price;
        this.prod_id = prod_id;
        this.ord_id = ord_id;
    }
    public Long getOrd_item_id() {
        return ord_item_id;
    }
    public void setOrd_item_id(Long ord_item_id) {
        this.ord_item_id = ord_item_id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Long getProd_id() {
        return prod_id;
    }
    public void setProd_id(Long prod_id) {
        this.prod_id = prod_id;
    }
    public Long getOrd_id() {
        return ord_id;
    }
    public void setOrd_id(Long ord_id) {
        this.ord_id = ord_id;
    }
    
}
