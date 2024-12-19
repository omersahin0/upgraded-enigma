package com.example.bidfood.business.concretes;

import com.example.bidfood.business.responses.CreateProductResponse;
import com.example.bidfood.dataAccess.abstracts.ProductRepository;
import com.example.bidfood.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductManager {

    @Autowired
    private ProductRepository productRepository;

    public CreateProductResponse getProductByProductCode(String productCode) {

        Product product = productRepository.findByProductCode(productCode);
        CreateProductResponse createProductResponse = new CreateProductResponse();
        createProductResponse.setProductCode(product.getProductCode());
        createProductResponse.setProductName(product.getProductName());
        createProductResponse.setOrderType(product.getOrderType());

        return createProductResponse;


    }
}

