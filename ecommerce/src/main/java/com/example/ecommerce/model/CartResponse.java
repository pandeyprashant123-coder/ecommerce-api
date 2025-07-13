package com.example.ecommerce.model;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class CartResponse {
    private UUID id;
    private UUID userId; // usedId
    private List<CartItemResponse> items;
}
