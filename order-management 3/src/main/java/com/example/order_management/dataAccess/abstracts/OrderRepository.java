package com.example.order_management.dataAccess.abstracts;

import com.example.order_management.entities.concretes.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByOrderCode(String orderCode);
    List<Order> findByOutletCode(String outletCode);
}
