package dev.venketesh.productservice.thirdpartyclient.productservice.fakestore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FakeStoreProductDTO implements Serializable {
    private Long id;
    private String title;
    private String category;
    private double price;
    private String description;
    private String image;
}
