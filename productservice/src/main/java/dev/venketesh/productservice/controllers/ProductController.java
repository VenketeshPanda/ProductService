package dev.venketesh.productservice.controllers;

import dev.venketesh.productservice.commons.AuthCommons;
import dev.venketesh.productservice.dto.GenericProductDTO;
import dev.venketesh.productservice.dto.Role;
import dev.venketesh.productservice.dto.UserDTO;
import dev.venketesh.productservice.exceptions.NotFoundExpception;
import dev.venketesh.productservice.models.Product;
import dev.venketesh.productservice.services.ProductService;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private AuthCommons authCommons;

    public ProductController(ProductService productService,AuthCommons authCommons){
        this.productService=productService;
        this.authCommons = authCommons;
    }

    @GetMapping
    public Page<GenericProductDTO> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
        return productService.getAllProducts(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericProductDTO> getProductById(@PathVariable("id") Long id) throws NotFoundExpception {
        GenericProductDTO productDTO = productService.getProductById(id);
        ResponseEntity<GenericProductDTO> responseEntity = new ResponseEntity<>(productDTO, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDTO> deleteProductById(@PathVariable("id") String id){
        ResponseEntity<GenericProductDTO> responseEntity = new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
        return responseEntity;
    }


    @PostMapping
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO genericProductDTO){
        return productService.createProduct(genericProductDTO);
    }

    @PutMapping("/{id}")
    public GenericProductDTO updateProductById(@RequestBody GenericProductDTO productDTO, @PathVariable UUID id){
        return productService.updateProduct(productDTO, id);
    }
}
