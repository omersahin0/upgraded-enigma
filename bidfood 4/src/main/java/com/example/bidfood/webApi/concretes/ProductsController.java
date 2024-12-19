package com.example.bidfood.webApi.concretes;

import com.example.bidfood.business.concretes.ProductManager;
import com.example.bidfood.business.responses.CreateProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductsController {

    @Autowired
    private ProductManager productManager;

    @GetMapping("/product")
    public CreateProductResponse getProductByProductCode(String productCode)
    {
        return productManager.getProductByProductCode(productCode);
    }

}