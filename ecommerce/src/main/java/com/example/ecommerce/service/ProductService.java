package com.example.ecommerce.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.ProductListRequest;
import com.example.ecommerce.model.ProductRequest;
import com.example.ecommerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public static final String UPLOAD_DIR = "src/main/resources/static/images/";

    public String saveImage(MultipartFile image) throws IOException {
        String fileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + fileName);
        Files.createDirectories(path.getParent());
        Files.write(path, image.getBytes());
        return fileName;
    }

    public Product createProduct(ProductRequest request, MultipartFile image) throws IOException {
        if (image != null && !image.isEmpty()) {
            String filename = saveImage(image);
            request.setImage(filename);
        }
        var product = Product.builder().name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .image(request.getImage()).build();

        return repository.save(product);
    }

    public Page<ProductListRequest> getAllProducts(Pageable pageable) {
        return repository.findAllWithoutComments(pageable);
    }

    public Product getProduct(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public Product updateProduct(UUID id, ProductRequest product, MultipartFile image) throws IOException {
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        if (image != null && !image.isEmpty()) {
            String fileName = saveImage(image);
            existingProduct.setImage("/images/" + fileName);
        }
        return repository.save(existingProduct);
    }

    public void deleteProduct(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found");
        }
        repository.deleteById(id);
    }
}
