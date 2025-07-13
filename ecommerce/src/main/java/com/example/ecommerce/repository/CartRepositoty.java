package com.example.ecommerce.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.Cart;

public interface CartRepositoty extends JpaRepository<Cart, UUID> {
    Optional<Cart> findByUserId(UUID userId);
}
