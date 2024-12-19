package com.example.order_management.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {
    private String orderCode;
    private String outletCode;
    private List<ProductRequest> products;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductRequest {
        private String productCode;
        private int quantity;
    }
}