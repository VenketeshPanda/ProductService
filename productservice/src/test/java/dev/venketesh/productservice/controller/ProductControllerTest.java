package dev.venketesh.productservice.controller;

import dev.venketesh.productservice.exceptions.NotFoundExpception;
import dev.venketesh.productservice.thirdpartyclient.productservice.fakestore.FakeStoreProductServiceClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductControllerTest {
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    @Test
    @DisplayName("1 + 1 = 2")
    void testOnePlusOneEqualsTwo() throws NotFoundExpception {
        assertEquals(2, 1+1,"1 + 1 should equal 2");
//        assertNull(fakeStoreProductServiceClient.getProductById(UUID.randomUUID()));
    }


}
