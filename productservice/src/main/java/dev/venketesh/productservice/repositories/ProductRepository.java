package dev.venketesh.productservice.repositories;

import dev.venketesh.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByUuid(UUID uuid);
    Page<Product> findAll(Pageable pageable);
}
