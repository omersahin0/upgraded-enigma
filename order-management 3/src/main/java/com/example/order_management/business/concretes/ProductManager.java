package com.example.order_management.business.concretes;

import com.example.order_management.business.abstracts.ProductService;
import com.example.order_management.business.request.ProductCreateRequest;
import com.example.order_management.business.responses.ProductResponse;
import com.example.order_management.core.utulities.mappers.ModelMapperService;
import com.example.order_management.dataAccess.abstracts.ProductRepository;
import com.example.order_management.entities.concretes.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManager implements ProductService {

    private ProductRepository repository;
    private ModelMapperService modelMapperService;
    public ProductManager(ProductRepository repository, ModelMapperService modelMapperService) {
        this.repository = repository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = repository.findAll();

        return products.stream().map(product -> modelMapperService.forResponse().map(product, ProductResponse.class))
                .toList();    }

    @Override
    public ProductResponse getProductById(String id) {
        Product product = repository.findById("id").orElseThrow(() -> new RuntimeException("Order not found with id : " +id));
        return modelMapperService.forResponse().map(product, ProductResponse.class);
    }

    @Override
    public void createProduct(ProductCreateRequest productCreateRequest) {
        Product product = modelMapperService.forRequest().map(productCreateRequest, Product.class);
        repository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        repository.deleteById("id");

    }
}
