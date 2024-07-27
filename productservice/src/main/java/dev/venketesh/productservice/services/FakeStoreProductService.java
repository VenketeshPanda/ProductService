package dev.venketesh.productservice.services;

import dev.venketesh.productservice.thirdpartyclient.productservice.fakestore.FakeStoreProductDTO;
import dev.venketesh.productservice.dto.GenericProductDTO;
import dev.venketesh.productservice.exceptions.NotFoundExpception;
import dev.venketesh.productservice.thirdpartyclient.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductService implements ProductService {

    private final FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient=fakeStoreProductServiceClient;
    }

    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundExpception {
       return convertFakeStoreDTOToGenericProductDTO(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product){
        return convertFakeStoreDTOToGenericProductDTO(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public List<GenericProductDTO> getAllProducts(){
        List<GenericProductDTO> products = new ArrayList<>();
        List<FakeStoreProductDTO> fakeStoreProductDTOS = fakeStoreProductServiceClient.getAllProducts();
        for(FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOS){
            products.add(convertFakeStoreDTOToGenericProductDTO(fakeStoreProductDTO));
        }
        return products;
    }

    @Override
    public GenericProductDTO deleteProduct(Long id) {
        return convertFakeStoreDTOToGenericProductDTO(fakeStoreProductServiceClient.deleteProduct(id));
    }


    @Override
    public GenericProductDTO updateProduct(GenericProductDTO product, Long id){
        return convertFakeStoreDTOToGenericProductDTO(fakeStoreProductServiceClient.updateProduct(product,id));
    }

    private GenericProductDTO convertFakeStoreDTOToGenericProductDTO(FakeStoreProductDTO fakeStoreProductDTO){
        GenericProductDTO product = new GenericProductDTO();
        product.setImage(fakeStoreProductDTO.getImage());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setCategory(fakeStoreProductDTO.getCategory());
        product.setPrice(fakeStoreProductDTO.getPrice());
        return product;
    }
}
