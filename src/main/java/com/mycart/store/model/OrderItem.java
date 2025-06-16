package com.mycart.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDERITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDITEMID")
    private Long ordItemId;
    @Column(name = "QUANTITY", nullable = false, unique = false)
    private int quantity;
    @Column(name = "PRICE", nullable = false, unique = false)
    private double price;
    @ManyToOne()
    @JoinColumn(name = "PROD_ID", referencedColumnName = "PROD_ID")
    private Product product;
    @ManyToOne()
    @JoinColumn(name = "ORD_ID", referencedColumnName = "ORD_ID")
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