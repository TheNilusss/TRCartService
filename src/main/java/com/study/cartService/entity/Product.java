package com.study.cartService.entity;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    public String id;

    public String name;
    public double price;
    public String currency;

    public Product() {
    }

    public Product(String name, double price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }
}