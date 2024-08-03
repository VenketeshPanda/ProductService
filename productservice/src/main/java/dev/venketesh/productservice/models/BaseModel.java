package dev.venketesh.productservice.models;


import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id",columnDefinition = "binary(16)",nullable = false,updatable = false)
    private UUID uuid;
}
