package com.example.ecommerce.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductListRequest {
    private UUID id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @Positive(message = "Price must be positive")
    private BigDecimal price;
    @PositiveOrZero(message = "Qunatity must be positive or zero")
    private Integer quantity;
    private String image;
}
