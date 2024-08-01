package dev.venketesh.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private String  image;


    //P:C 1P:1C 1C:M-P
    @ManyToOne
    private Category category;
    private double price;
}
