package com.example.order_management.webApi.concretes;

import com.example.order_management.business.abstracts.ProductService;
import com.example.order_management.business.request.OutletCreateRequest;
import com.example.order_management.business.request.ProductCreateRequest;
import com.example.order_management.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductsController {
    private ProductService productService;

    @PostMapping("/products")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductCreateRequest createProductRequest) {
        productService.createProduct(createProductRequest);
    }
}
