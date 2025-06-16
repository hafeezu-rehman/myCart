package com.mycart.store.model;

public class Order {
    private Long ord_id;
    private String status;
    private double total_amount;
    private double user_id;
    private double add_id;
    public Order() {
    }
    public Order(Long ord_id, String status, double total_amount, double user_id, double add_id) {
        this.ord_id = ord_id;
        this.status = status;
        this.total_amount = total_amount;
        this.user_id = user_id;
        this.add_id = add_id;
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
    public double getUser_id() {
        return user_id;
    }
    public void setUser_id(double user_id) {
        this.user_id = user_id;
    }
    public double getAdd_id() {
        return add_id;
    }
    public void setAdd_id(double add_id) {
        this.add_id = add_id;
    }
    
}
