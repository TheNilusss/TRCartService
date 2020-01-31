package com.study.cartService.entity;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public String email;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}