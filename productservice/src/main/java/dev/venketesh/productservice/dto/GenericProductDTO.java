package dev.venketesh.productservice.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDTO {
    private Long id;
    private String title;
    private String category;
    private double price;
    private String description;
    private String image;
}
