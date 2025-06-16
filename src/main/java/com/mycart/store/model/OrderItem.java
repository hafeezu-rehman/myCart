package com.mycart.store.model;
public class OrderItem {
    private Long ordItemId;
    private int quantity;
    private double price;
    private Product product;
    private Order order;
    public OrderItem() {
    }
    public OrderItem(Long ordItemId, int quantity, double price, Product product, Order order) {
        this.ordItemId = ordItemId;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.order = order;
    }
    public Long getOrdItemId() {
        return ordItemId;
    }
    public void setOrdItemId(Long ordItemId) {
        this.ordItemId = ordItemId;
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
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

}