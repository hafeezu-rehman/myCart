package com.mycart.store.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORD_ID")
    private Long ord_id;
    @Column(name = "Status", nullable = false, unique = false)
    private String status;
    @Column(name = "TOTAL_AMOUNT", nullable = false, unique = false)
    private double total_amount;
    @ManyToOne()
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;
    public Order() {
    }
    public Order(Long ord_id, String status, double total_amount, User user) {
        this.ord_id = ord_id;
        this.status = status;
        this.total_amount = total_amount;
        this.user = user;
    }
    public Long getOrd_id() {
        return ord_id;
    }
    public void setOrd_id(Long ord_id) {
        this.ord_id = ord_id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getTotal_amount() {
        return total_amount;
    }
    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}