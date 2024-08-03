package dev.venketesh.productservice;

import dev.venketesh.productservice.models.Category;
import dev.venketesh.productservice.models.Product;
import dev.venketesh.productservice.repositories.CategoryRepository;
import dev.venketesh.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductserviceApplication(ProductRepository productRepository,
									 CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}


	@Override
	public void run(String...args) throws Exception{

		Category category = new Category();
		category.setName("Tops");
		Category savedCategory = categoryRepository.save(category);

		Product product = new Product();
		product.setTitle("Shirt");
		product.setPrice(200.0);
		product.setDescription("Oversized tshirt");
		product.setCategory(savedCategory);
		productRepository.save(product);

		Category category1 = categoryRepository.findById(UUID.fromString("38c15217-9687-442c-b919-90f2e40bccc4")).get();
		System.out.println("Category 1: " + category1.getName());
	}

}
