package dev.venketesh.productservice.services;

import dev.venketesh.productservice.dto.GenericProductDTO;
import dev.venketesh.productservice.exceptions.NotFoundExpception;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    GenericProductDTO createProduct(GenericProductDTO product);
    GenericProductDTO getProductById(UUID id) throws NotFoundExpception;
    List<GenericProductDTO> getAllProducts();

    GenericProductDTO deleteProduct(String id);

    GenericProductDTO updateProduct(GenericProductDTO productDTO, UUID id);
}
