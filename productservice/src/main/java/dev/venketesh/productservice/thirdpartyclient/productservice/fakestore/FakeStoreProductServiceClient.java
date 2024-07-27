package dev.venketesh.productservice.thirdpartyclient.productservice.fakestore;

import dev.venketesh.productservice.dto.GenericProductDTO;
import dev.venketesh.productservice.exceptions.NotFoundExpception;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/***
 * Wrapper over FakeStore API
 */

@Service
public class FakeStoreProductServiceClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private final String specificProductRequestUrl;
    private final String specificProductRequestUrlProduct;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}") String baseUrl
                                         ,@Value("${fakestore.api.paths.products}")String productUrl) {
        this.restTemplateBuilder=restTemplateBuilder;
        this.specificProductRequestUrlProduct=baseUrl+productUrl+"/{id}";
        this.specificProductRequestUrl=baseUrl+productUrl;
    }

    public FakeStoreProductDTO getProductById(Long id) throws NotFoundExpception {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(specificProductRequestUrlProduct, FakeStoreProductDTO.class,id);
        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();

        return fakeStoreProductDTO;
    }


    public FakeStoreProductDTO createProduct(GenericProductDTO product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity =
                restTemplate.postForEntity(specificProductRequestUrl,product, FakeStoreProductDTO.class);
        return responseEntity.getBody();
    }


    public List<FakeStoreProductDTO> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> responseEntity =
                restTemplate.getForEntity(specificProductRequestUrlProduct,FakeStoreProductDTO[].class);

        List<FakeStoreProductDTO> fakeStoreProductDTOs = new ArrayList<>();
        fakeStoreProductDTOs.addAll(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));
        return fakeStoreProductDTOs;
    }

    public FakeStoreProductDTO deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        ResponseEntity<FakeStoreProductDTO> responseEntity= restTemplate.execute(specificProductRequestUrlProduct, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }

    public FakeStoreProductDTO updateProduct(GenericProductDTO product, Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpEntity<GenericProductDTO> requestEntity = new HttpEntity<>(product);

        ResponseEntity<FakeStoreProductDTO> response = restTemplate.exchange(
                specificProductRequestUrlProduct,
                HttpMethod.PUT,
                requestEntity,
                FakeStoreProductDTO.class,
                id
        );

        return response.getBody();
    }
}
