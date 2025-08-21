package com.example2.demo2;

public class Order {
    private Integer id;
    private String productName;
    private int quantity;


    public Order(Integer id, String productName, int quantity, int price) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    } 
}
