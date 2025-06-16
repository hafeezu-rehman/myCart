package com.mycart.store.model;

public class Order {
    private Long ord_id;
    private String status;
    private double total_amount;
    private User user;
    private Address address;
    public Order() {
    }
    public Order(Long ord_id, String status, double total_amount, User user, Address address) {
        this.ord_id = ord_id;
        this.status = status;
        this.total_amount = total_amount;
        this.user = user;
        this.address = address;
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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    
}