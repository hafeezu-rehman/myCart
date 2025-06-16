package com.mycart.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEG_ID")
    private Long categ_id;
    @Column(name = "NAME", nullable = false, unique = false)
    private String name;
    @Column(name = "DESCRIPTION", nullable = false, unique = false)
    private String description;
    public Category() {
    }
    public Category(Long categ_id, String name, String description) {
        this.categ_id = categ_id;
        this.name = name;
        this.description = description;
    }
    public Long getCateg_id() {
        return categ_id;
    }
    public void setCateg_id(Long categ_id) {
        this.categ_id = categ_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
