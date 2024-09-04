package dev.venketesh.productservice.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public class BaseModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition = "binary(16)",nullable = false,updatable = false)
    private Long id;
}
