package com.study.cartService.controller;

import com.study.cartService.entity.Cart;
import com.study.cartService.entity.Customer;
import com.study.cartService.entity.Product;
import com.study.cartService.entity.ResponseObject;
import com.study.cartService.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CartServiceController {

    ResponseObject resObj = new ResponseObject();

    @Autowired
    private CartRepository repository;

    @PostMapping("/cart")
    void createCart(@RequestParam final String cuID) {
        if (existCustomer(cuID) && !existCart(cuID)) {
            repository.save(new Cart(cuID));
            System.out.println("Cart created.");
        } else {
            System.out.println("Cart don't created.");
        }
    }

    boolean existCustomer(String ID) {
        Customer customer = resObj.receive(Customer.class, "http://localhost:8081/customer?ID=" + ID);
        if (customer == null) {
            System.out.println("Customer don't exist.");
            return false;
        }
        System.out.println("Customer exist.");
        return true;
    }

    boolean existCart(String ID) {
        if (repository.findByCuID(ID) == null) {
            System.out.println("Cart don't exist.");
            return false;
        }
        System.out.println("Cart exist.");
        return true;
    }

    @PostMapping("/addToCart")
    void addToCart(@RequestParam final String CaID, @RequestParam final String PID) {

        Cart cart = repository.findByid(CaID);
        if (cart == null) {
            System.out.println("Cart don't exist");
        } else {
            if (existProduct(PID)) {
                if(cart.getSelectedItems().get(PID) != null)
                {
                    int value = cart.getSelectedItems().get(PID).intValue() + 1;
                    cart.getSelectedItems().put(PID,value);
                }else {
                    cart.getSelectedItems().put(PID,1);
                }
                repository.save(cart);

                System.out.println("Product added to cart.");
            } else {
                System.out.println("Product don't added to cart.");
            }
        }
    }

    boolean existProduct(String ID) {
        Product product = resObj.receive(Product.class, "http://localhost:8082/product?ID=" + ID);
        if (product == null) {
            System.out.println("Product don't exist.");
            return false;
        }
        System.out.println("Product exist.");
        return true;
    }

    @GetMapping("/cart")
    Cart getCart(@RequestParam final String ID) {
        Cart cart = repository.findByid(ID);
        if (cart != null) {
            System.out.println("send cart by ID: " + cart.id);
        } else {
            System.out.println("send no cart");
        }
        return cart;
    }

    //DEBUGGING
    @GetMapping("/cart/db/show")
    ArrayList<Cart> showDb() {
        ArrayList<Cart> arrayListObj = new ArrayList<>();
        for (Cart obj : repository.findAll()) {
            arrayListObj.add(obj);
        }
        return arrayListObj;
    }

    //DEBUGGING
    @PostMapping("/cart/db/clear")
    void clear() {
        repository.deleteAll();
    }
}