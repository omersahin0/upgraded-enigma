package com.example.order_management.business.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class OutletUpdateRequest {
        private String id;
        private String outletCode;
        private String address;
        private String signName;
        private double longitude;
        private double latitude;
    }

