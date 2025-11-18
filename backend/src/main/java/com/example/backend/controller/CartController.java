package com.example.backend.controller;

import java.util.UUID;
import org.springframework.web.bind.annotation.*;

import com.example.backend.model.Cart;
import com.example.backend.service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

  
    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable UUID cartId) {
        return service.getCart(cartId);
    }


    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return service.save(cart);
    }
}
