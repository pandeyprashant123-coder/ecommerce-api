package com.example.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.example.ecommerce.entity.Order;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderRequest {
    private UUID id;
    private Long userId;
    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "Phone name is required")
    private String phoneNumber;
    private Order.OrderStatus status;
    private LocalDateTime createdAt;
    private List<OrderItem> orderItems;
}
