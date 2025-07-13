package com.example.ecommerce.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByProductId(UUID userId);
}
