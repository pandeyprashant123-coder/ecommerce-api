package com.example.ecommerce.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.model.ProductListRequest;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT new com.example.ecommerce.model.ProductListRequest(p.id, p.name, p.description, p.price, p.quantity, p.image) FROM Product p")
    Page<ProductListRequest> findAllWithoutComments(Pageable pageable);
}
