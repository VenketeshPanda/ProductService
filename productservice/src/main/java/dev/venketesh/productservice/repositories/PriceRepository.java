package dev.venketesh.productservice.repositories;

import dev.venketesh.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}
