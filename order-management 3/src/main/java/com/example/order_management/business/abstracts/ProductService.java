package com.example.order_management.business.abstracts;

import com.example.order_management.business.request.ProductCreateRequest;
import com.example.order_management.business.responses.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(String id);
    void createProduct(ProductCreateRequest productCreateRequest);
    void deleteProduct(String id);
}
