package com.example.order_management.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutletCreateRequest {
    private String outletCode;
    private String address;
    private String sign_name;
    private double longitude;
    private double latitude;

}
