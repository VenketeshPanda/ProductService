package dev.venketesh.productservice.dto;
import dev.venketesh.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenericProductDTO {
    private String id;
    private String title;
    private String category;
    private double price;
    private String description;
    private String image;
}
