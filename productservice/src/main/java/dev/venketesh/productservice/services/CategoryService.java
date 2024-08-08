package dev.venketesh.productservice.services;

import dev.venketesh.productservice.models.Category;

import java.util.List;

public interface CategoryService {
    public Category getCategory(String uuid);
    List<String> getProductTitles(String uuid);
}
