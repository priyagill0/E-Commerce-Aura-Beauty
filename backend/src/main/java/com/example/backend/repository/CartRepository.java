package com.example.backend.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.model.Cart;

public interface CartRepository extends JpaRepository<Cart, UUID> {
    Cart findBySessionId(String sessionId);
}