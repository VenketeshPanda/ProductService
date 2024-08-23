//package dev.venketesh.productservice.controller;
//
//import dev.venketesh.productservice.controllers.ProductController;
//import dev.venketesh.productservice.dto.GenericProductDTO;
//import dev.venketesh.productservice.exceptions.NotFoundExpception;
//import dev.venketesh.productservice.services.ProductService;
//import dev.venketesh.productservice.thirdpartyclient.productservice.fakestore.FakeStoreProductServiceClient;
//import org.hibernate.annotations.GenericGenerator;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class ProductControllerTest {
//
//    @Autowired
//    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
//
//    @Autowired
//    private ProductController productController;
//
//    @MockBean
//    private ProductService productService;
//
//    @Captor
//    private final ArgumentCaptor<UUID> uuidArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
//
//    @Test
//    @DisplayName("Get Product By Id")
//    void testGetProductById() throws NotFoundExpception {
//        UUID uuid = UUID.randomUUID();
//
//        GenericProductDTO mockGenericProductDTO= new GenericProductDTO();
//        mockGenericProductDTO.setId(String.valueOf(uuid));
//        mockGenericProductDTO.setCategory("TestCat");
//        mockGenericProductDTO.setTitle("TestTitle");
//        mockGenericProductDTO.setDescription("Testing it");
//
//        when(productService
//                .getProductById(uuid))
//                .thenReturn(mockGenericProductDTO);
//
////        GenericProductDTO genericProductDTO = productController.getProductById(uuid,"");
//
//        assertEquals("TestCat",genericProductDTO.getCategory());
//        assertEquals("TestTitle",genericProductDTO.getTitle());
//
//    }
//
//    @Test
//    void testProductControllerCallsProductServiceWithSameProductId() throws NotFoundExpception {
//        UUID uuid = UUID.randomUUID();
//        when(productService.getProductById(uuid)).thenReturn(new GenericProductDTO());
//
//        //Check if the product service is being called with the exact same param as controller
//        productController.getProductById(uuid,"");
//        verify(productService).getProductById(uuidArgumentCaptor.capture());
//        assertEquals(uuid, uuidArgumentCaptor.getValue());
//    }
//}
