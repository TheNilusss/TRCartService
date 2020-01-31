package com.study.cartService.entity;

import org.springframework.data.annotation.Id;

public class Order {

    @Id
    String id;

    String customerID;
    String cartID;
    double moneyPaid;
    String currency;

    public Order() {
    }

    public Order(String customerID, String cartID, double moneyPaid, String currency) {
        this.customerID = customerID;
        this.cartID = cartID;
        this.moneyPaid = moneyPaid;
    }
}