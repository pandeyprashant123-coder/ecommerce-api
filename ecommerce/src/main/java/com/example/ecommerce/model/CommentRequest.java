package com.example.ecommerce.model;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentRequest {
    private UUID id;
    @NotBlank(message = "Content is required")
    private String content;
    @Min(value = 1)
    @Max(value = 5)
    private Integer score;
    private UUID userId;
}
