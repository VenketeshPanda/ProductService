package dev.venketesh.productservice.repositories;

import dev.venketesh.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query(value = "SELECT * FROM Product WHERE title = :title",nativeQuery = true)
    List<Product> findAllByTitleEquals(String title);


    Product findByTitleAndPrice_Value(String title, Double value);
    List<Product> findAllByPrice_Value(Double value);
}
