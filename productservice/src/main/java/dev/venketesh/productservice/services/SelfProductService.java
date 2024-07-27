package dev.venketesh.productservice.services;

import dev.venketesh.productservice.dto.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductService implements ProductService{
    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        return null;
    }

    @Override
    public GenericProductDTO getProductById(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDTO deleteProduct(Long id) {

        return null;
    }

    @Override
    public GenericProductDTO updateProduct(GenericProductDTO productDTO, Long id) {
        return null;
    }
}
