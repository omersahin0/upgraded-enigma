package com.example.order_management.business.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {
    private String productCode;
    private int size;
    private String name;
}