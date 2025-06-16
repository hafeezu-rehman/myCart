package com.mycart.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ADD_ID")
    private Long add_id;
    @Column(name = "HOUSE", nullable = false, unique = false)
    private String house;
    @Column(name = "STREET", nullable = false, unique = false)
    private String street;
    @Column(name = "CITY", nullable = false, unique = false)
    private String city;
    @Column(name = "PROVINCE", nullable = false, unique = false)
    private String province;
    @Column(name = "COUNTRY", nullable = false, unique = false)
    private String country;
    public Address() {
    }
    public Address(Long add_id, String house, String street, String city, String province, String country) {
        this.add_id = add_id;
        this.house = house;
        this.street = street;
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
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
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
