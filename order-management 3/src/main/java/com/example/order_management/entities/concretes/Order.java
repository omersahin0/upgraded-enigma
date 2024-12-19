package com.example.order_management.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private ObjectId id;

    @Field("orderCode")
    private String orderCode;

    @Field("outletCode")
    private String outletCode;

    @Field("products")
    private List<ProductRequest> products;

    @Field("status")
    private Status status;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductRequest {
        private String productCode;
        private int quantity;
    }


}
