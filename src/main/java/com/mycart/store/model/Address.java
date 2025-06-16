package com.mycart.store.model;

public class Address {
    private Long add_id;
    private String house;
    private String steet;
    private String city;
    private String province;
    private String country;
    public Address() {
    }
    public Address(Long add_id, String house, String steet, String city, String province, String country) {
        this.add_id = add_id;
        this.house = house;
        this.steet = steet;
        this.city = city;
        this.province = province;
        this.country = country;
    }
    public Long getAdd_id() {
        return add_id;
    }
    public void setAdd_id(Long add_id) {
        this.add_id = add_id;
    }
    public String getHouse() {
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }
    public String getSteet() {
        return steet;
    }
    public void setSteet(String steet) {
        this.steet = steet;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    
}
