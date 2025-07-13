package com.example.ecommerce.model;

import java.util.UUID;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CartItemResponse {
    private UUID id;
    private UUID productId;
    @Positive
    private Integer quantity;
}
