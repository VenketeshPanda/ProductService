package dev.venketesh.productservice;


import dev.venketesh.productservice.models.Category;
import dev.venketesh.productservice.models.Product;
import dev.venketesh.productservice.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

	private final CategoryRepository categoryRepository;

	public ProductserviceApplication(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		doSomething();
	}

	@Transactional
	public void doSomething(){
		Optional<Category> category = Optional.of(new Category());
		category = categoryRepository.findById(UUID.fromString("0c99c03f-ef46-48ce-93f3-d62d929f5f93"));
		System.out.println(category.get().getName());
		Category category1 = category.get();
		List<Product> productList = category1.getProducts();

		System.out.println(productList.size());
	}
}
