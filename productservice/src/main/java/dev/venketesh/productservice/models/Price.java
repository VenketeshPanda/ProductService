package dev.venketesh.productservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "price")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price extends BaseModel {
    String currency;
    double value=0.0;
}
