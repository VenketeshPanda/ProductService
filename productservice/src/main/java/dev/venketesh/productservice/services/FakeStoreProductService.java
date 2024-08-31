package dev.venketesh.productservice.services;

import dev.venketesh.productservice.thirdpartyclient.productservice.fakestore.FakeStoreProductDTO;
import dev.venketesh.productservice.dto.GenericProductDTO;
import dev.venketesh.productservice.exceptions.NotFoundExpception;
import dev.venketesh.productservice.thirdpartyclient.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductService implements ProductService {

    private final FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient=fakeStoreProductServiceClient;
    }

    @Override
    public GenericProductDTO getProductById(UUID id) throws NotFoundExpception {
       return convertFakeStoreDTOToGenericProductDTO(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product){
        return convertFakeStoreDTOToGenericProductDTO(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public Page<GenericProductDTO> getAllProducts(int pageNumber, int pageSize) {
        List<GenericProductDTO> products = new ArrayList<>();
        List<FakeStoreProductDTO> fakeStoreProductDTOS = fakeStoreProductServiceClient.getAllProducts();
        for(FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOS){
            products.add(convertFakeStoreDTOToGenericProductDTO(fakeStoreProductDTO));
        }
        return null;
    }

    @Override
    public GenericProductDTO deleteProduct(String id) {
        return null;
    }

    @Override
    public GenericProductDTO updateProduct(GenericProductDTO productDTO, UUID id) {
        return null;
    }

    private GenericProductDTO convertFakeStoreDTOToGenericProductDTO(FakeStoreProductDTO fakeStoreProductDTO){
        GenericProductDTO product = new GenericProductDTO();
        product.setImage(fakeStoreProductDTO.getImage());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setPrice(fakeStoreProductDTO.getPrice());
        return product;
    }
}
