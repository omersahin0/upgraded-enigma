package com.example.bidfood.dataAccess.abstracts;

import com.example.bidfood.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Order findByOrderCode(String orderCode);
}
