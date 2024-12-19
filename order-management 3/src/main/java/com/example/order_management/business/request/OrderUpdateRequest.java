package com.example.order_management.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderUpdateRequest {
    private String Id;
    private String id;
    private String orderCode;
    private String status; // PENDING, ACCEPTED, REJECTED
    private int quantity;
    private String productId;
    private String outletId;
}
