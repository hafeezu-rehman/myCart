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
@Table(name="ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORD_ID")
    private Long ord_id;
    @Column(name = "Status", nullable = false, unique = false)
    private String status;
    @Column(name = "TOTAL_AMOUNT", nullable = false, unique = false)
    private Double total_amount;
    @ManyToOne()
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;
    public Order() {
    }
    public Order(Long ord_id, String status, Double total_amount, User user) {
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
    public Double getTotal_amount() {
        return total_amount;
    }
    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}