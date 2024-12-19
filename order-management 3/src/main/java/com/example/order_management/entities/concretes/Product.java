package com.example.order_management.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "products")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    private ObjectId id;
    @Field("productCode")
    private String productCode;
    @Field("size")
    private int size;
    @Field("name")
    private String name;

}
