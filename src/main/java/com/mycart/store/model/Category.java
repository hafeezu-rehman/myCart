package com.mycart.store.model;

public class Category {
    private Long categ_id;
    private String name;
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
