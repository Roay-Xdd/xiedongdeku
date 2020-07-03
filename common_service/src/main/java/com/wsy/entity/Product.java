package com.wsy.entity;

import java.io.Serializable;

public class Product implements Serializable {


    private Integer id;
    private float price;
    private String productName;

    private Integer stock;

    public Product() {
    }

    public Product(Integer id, float price, String productName, Integer stock) {
        this.id = id;
        this.price = price;
        this.productName = productName;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                ", stock=" + stock +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
