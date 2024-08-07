package dev.venketesh.productservice.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
    //Same relation mapped by category attribute in the other class
    //Category category in Products is mapped to List<Product> products;
}
