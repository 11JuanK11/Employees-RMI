package com.example2.demo2;

public class Product {
    private Integer id;
    private String name;

    
    public Product(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }    
}


