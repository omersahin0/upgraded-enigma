package com.example.order_management.business.responses;

import com.example.order_management.entities.concretes.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse  {
    private String id;
    private String orderCode;
    private Status status; // PENDING, ACCEPTED, REJECTED
    private int quantity;
    private String productId;
    private String outletId;
}