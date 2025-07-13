package com.example.ecommerce.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItem {
    private UUID id;
    private UUID productId;
    @Positive
    private Integer quantity;
    @Positive
    private BigDecimal price;
}
