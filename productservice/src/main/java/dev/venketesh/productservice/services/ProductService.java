package dev.venketesh.productservice.services;

import dev.venketesh.productservice.dto.GenericProductDTO;
import dev.venketesh.productservice.exceptions.NotFoundExpception;

import java.util.List;

public interface ProductService {

    GenericProductDTO createProduct(GenericProductDTO product);
    GenericProductDTO getProductById(Long id) throws NotFoundExpception;
    List<GenericProductDTO> getAllProducts();
    GenericProductDTO deleteProduct(Long id);

    GenericProductDTO updateProduct(GenericProductDTO productDTO, Long id);
}
