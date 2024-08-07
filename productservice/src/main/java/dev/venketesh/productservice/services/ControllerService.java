package dev.venketesh.productservice.services;

import dev.venketesh.productservice.models.Category;
import dev.venketesh.productservice.models.Product;
import dev.venketesh.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ControllerService implements CategoryService {

    CategoryRepository categoryRepository;

    public ControllerService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategory(String uuid) {
        Optional<Category> category = categoryRepository.findById(UUID.fromString(uuid));
        if(category.isEmpty()){
            return null;
        }
        return category.get();
    }
}
