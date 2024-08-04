package dev.venketesh.productservice;

import dev.venketesh.productservice.models.Category;
import dev.venketesh.productservice.models.Price;
import dev.venketesh.productservice.models.Product;
import dev.venketesh.productservice.repositories.CategoryRepository;
import dev.venketesh.productservice.repositories.PriceRepository;
import dev.venketesh.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final PriceRepository priceRepository;

	public ProductserviceApplication(ProductRepository productRepository,
									 CategoryRepository categoryRepository, PriceRepository priceRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.priceRepository = priceRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}


	@Override
	public void run(String...args) {

		Category category = new Category();
		category.setName("Tops");
//		Category savedCategory = categoryRepository.save(category);

		Price price = new Price();
		price.setCurrency("INR");
		price.setValue(2000.0);

//		Price savedPrice = priceRepository.save(price);

		Product product = new Product();
		product.setTitle("Shirt");
		product.setPrice(price);
		product.setDescription("Oversized tshirt");
		product.setCategory(category);
		productRepository.save(product);

//		List<Product> items = productRepository.findAllByPrice_Value(2000.0);
//		for(Product item: items){
//			System.out.println(item.getTitle());
//			System.out.println(item.getCategory());
//		}

		List<Product> product1 = productRepository.findAllByTitleEquals("Shirt");
		for(Product item: product1){
			System.out.println(item.getTitle());
			System.out.println(item.getCategory().getName());
		}


//		Category category1 = categoryRepository.findById(UUID.fromString("38c15217-9687-442c-b919-90f2e40bccc4")).get();
//		System.out.println("Category 1: " + category1.getName());
	}

}
