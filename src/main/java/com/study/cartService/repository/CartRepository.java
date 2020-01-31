package com.study.cartService.repository;

import com.study.cartService.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface CartRepository extends MongoRepository<Cart, String> {

    public Cart findByid(String id);
    public Cart findByCuID(String cuID);
    public Cart findBySelectedItems(ArrayList<String> selectedItems);
}