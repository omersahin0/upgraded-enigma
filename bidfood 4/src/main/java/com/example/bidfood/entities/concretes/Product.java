package com.example.bidfood.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uid;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "size1")
    private int size1;

    @Column(name = "size2")
    private int size2;

    @Column(name = "size3")
    private int size3;

    @Column(name = "size4")
    private int size4;

    @Column(name = "quantity_unit")
    private String quantityUnit;

    @Column(name = "order_type")
    private String orderType;



}
