package com.example.bidfood.dataAccess.abstracts;

import com.example.bidfood.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByProductCode(String productCode);


}
