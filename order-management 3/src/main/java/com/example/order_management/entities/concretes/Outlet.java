package com.example.order_management.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "outlets")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Outlet {
    @Id
    private ObjectId id;
    @Field("outletId")
    private String outletId;
    @Field("outletCode")
    private String outletCode;
    @Field("address")
    private String address;
    @Field("signName")
    private String signName;
    @Field("longitude")
    private Double longitude;
    @Field("latitude")
    private Double latitude;
}
