//package dev.venketesh.productservice.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import dev.venketesh.productservice.controllers.ProductController;
//import dev.venketesh.productservice.dto.GenericProductDTO;
//import dev.venketesh.productservice.services.ProductService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.ArrayList;
//import java.util.UUID;
//
//import static org.hamcrest.Matchers.is;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(ProductController.class)
//public class ProductControllerWebMvcTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ProductService productService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void testGetAllProductsReturnsEmptyList() throws Exception {
//        when(productService
//                .getAllProducts())
//                .thenReturn(new ArrayList<>());
//
//        mockMvc.perform(
//                get("/products"))
//                .andExpect(status().is(200))
//                .andExpect(content().json("[]"));
//    }
//
//
//    @Test
//    void testReturnListOfProductsWhenProductExist() throws Exception {
//        ArrayList<GenericProductDTO> products = new ArrayList<>();
//        products.add(new GenericProductDTO());
//        products.add(new GenericProductDTO());
//        products.add(new GenericProductDTO());
//        when(productService.getAllProducts()).thenReturn(products);
//
//        mockMvc.perform(
//                get("/products"))
//                .andExpect(status().is(200))
//                .andExpect(content().json(objectMapper.writeValueAsString(products)));
//
//    }
//
//    @Test
//    void testCreateProductShouldCreateNewProduct() throws Exception {
//        UUID uuid = UUID.randomUUID();
//        GenericProductDTO mockGenericProductDTO= new GenericProductDTO();
//        mockGenericProductDTO.setId(String.valueOf(uuid));
//        mockGenericProductDTO.setCategory("TestCat");
//        mockGenericProductDTO.setTitle("TestTitle");
//        mockGenericProductDTO.setDescription("Testing it");
//
//        when(productService.createProduct(any())).thenReturn(mockGenericProductDTO);
//
//        mockMvc.perform(post("")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(mockGenericProductDTO)))
//                .andExpect(status().is(200))
//                .andExpect(content().json(objectMapper.writeValueAsString(mockGenericProductDTO)))
//                .andExpect(status().is(200)).andExpect(jsonPath("$.id", is(uuid.toString())))
//                .andExpect(jsonPath("$.category", is("TestCat")));
//
//    }
//
//}
