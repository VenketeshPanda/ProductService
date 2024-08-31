package dev.venketesh.productservice.services;

import dev.venketesh.productservice.dto.GenericProductDTO;
import dev.venketesh.productservice.exceptions.NotFoundExpception;
import dev.venketesh.productservice.models.Category;
import dev.venketesh.productservice.models.Price;
import dev.venketesh.productservice.models.Product;
import dev.venketesh.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service("selfProductServiceImpl")
public class SelfProductService implements ProductService {

    private final ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        Product product1 = new Product();
        Category category = new Category();
        category.setName(product.getCategory());
        product1.setCategory(category);
        product1.setImage(product.getImage());
        product1.setTitle(product.getTitle());

        Price price = new Price();
        price.setValue(product.getPrice());
        product1.setPrice(price);
        product1.setDescription(product.getDescription());

        Product savedProduct = productRepository.save(product1);
        GenericProductDTO productDTO = new GenericProductDTO();
        productDTO.setTitle(savedProduct.getTitle());
        productDTO.setDescription(savedProduct.getDescription());
        productDTO.setPrice(savedProduct.getPrice().getValue());
        productDTO.setCategory(savedProduct.getCategory().getName());
        return productDTO;
    }

    @Override
    public GenericProductDTO getProductById(UUID id) throws NotFoundExpception {
        Optional<Product> productOptional = Optional.ofNullable(productRepository.findByUuid(id));
        if (productOptional.isEmpty()) {
            throw new NotFoundExpception("Product not found");
        }
        Product product = productOptional.get();
        GenericProductDTO productDTO = new GenericProductDTO();
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice().getValue());
        productDTO.setCategory(product.getCategory().getName());
        return productDTO;
    }

    @Override
    public Page<GenericProductDTO> getAllProducts(int pageNumber, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNumber
                ,pageSize,
                Sort.by("title").ascending())).map(product -> {
            GenericProductDTO productDTO = new GenericProductDTO();
            productDTO.setTitle(product.getTitle());
            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice().getValue());
            productDTO.setCategory(product.getCategory().getName());
            return productDTO;
        });
    }

    @Override
    public GenericProductDTO deleteProduct(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Product> productOptional = productRepository.findById(uuid);
        Product product = productOptional.get();
        productRepository.delete(product);
        GenericProductDTO productDTO = new GenericProductDTO();
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice().getValue());
        return productDTO;
    }

    @Override
    public GenericProductDTO updateProduct(GenericProductDTO productDTO, UUID id) {
        UUID uuid = UUID.fromString(id.toString());
        Optional<Product> productOptional = productRepository.findById(uuid);
        Product product = productOptional.get();
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        productRepository.save(product);
        return productDTO;
    }
}