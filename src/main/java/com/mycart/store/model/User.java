package com.mycart.store.model;

public class User {
    private Long user_id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String phone_number;
    private Long add_id;
    public User() {
    }
    public User(Long user_id, String username, String email, String password, String role, String phone_number,
            Long add_id) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone_number = phone_number;
        this.add_id = add_id;
    }
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public Long getAdd_id() {
        return add_id;
    }
    public void setAdd_id(Long add_id) {
        this.add_id = add_id;
    }
    
}