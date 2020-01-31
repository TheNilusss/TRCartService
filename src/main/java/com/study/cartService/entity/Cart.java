package com.study.cartService.entity;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    @Id
    public String id;

    public String cuID;
    //ArrayList<String> selectedItems = new ArrayList<>();
    Map<String, Integer> selectedItems = new HashMap<String, Integer>();

    public Cart() {
    }

    public Cart(String cuID) {
        this.cuID = cuID;
    }

    public Cart(String cuID, Map<String, Integer> selectedItems) {
        this.cuID = cuID;
        this.selectedItems = selectedItems;
    }

    public Map<String, Integer> getSelectedItems() {
        return selectedItems;
    }
}