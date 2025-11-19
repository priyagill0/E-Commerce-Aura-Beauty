package com.example.backend.service;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.example.backend.model.Cart;
import com.example.backend.repository.CartRepository;

@Service
public class CartService {

    private final CartRepository repo;

    public CartService(CartRepository repo) {
        this.repo = repo;
    }

    public Cart getCart(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public Cart getCartBySession(String sessionId) {
        return repo.findBySessionId(sessionId);
    }

    public Cart save(Cart cart) {
        return repo.save(cart);
    }
}
