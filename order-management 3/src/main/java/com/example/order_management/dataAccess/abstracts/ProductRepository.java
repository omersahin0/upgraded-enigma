package com.example.order_management.dataAccess.abstracts;

import com.example.order_management.entities.concretes.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

}
