package dev.venketesh.productservice.controllers;

import dev.venketesh.productservice.dto.ProductDTO;
import dev.venketesh.productservice.models.Category;
import dev.venketesh.productservice.models.Product;
import dev.venketesh.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{uuid}")
    public List<ProductDTO> getCategory(@PathVariable("uuid") String uuid){
        List<Product> products= categoryService.getCategory(uuid).getProducts();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product: products){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setDescription(product.getDescription());
            productDTO.setTitle(product.getTitle());
            productDTO.setPrice(product.getPrice());
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    @GetMapping("/titles/{uuid}")
    public List<String> getProductTitles(@PathVariable("uuid") String uuid){
        return categoryService.getProductTitles(uuid);
    }
}
