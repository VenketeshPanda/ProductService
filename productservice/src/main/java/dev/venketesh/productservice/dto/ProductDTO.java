package dev.venketesh.productservice.dto;


import dev.venketesh.productservice.models.Category;
import dev.venketesh.productservice.models.Price;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String title;
    private String description;
    private String  image;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) //Add and remove price when product is added or removed
    private Price price;
}
