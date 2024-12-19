package com.example.bidfood.business.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProductResponse {

    @JsonProperty("product_code")
    private String productCode;
    @JsonProperty("product_name")
    private String productName;
    private int quantity;
    private int size1;
    private int size2;
    private int size3;
    private int size4;
    @JsonProperty("quantity_unit")
    private String quantityUnit;
    @JsonProperty("order_type")
    private String orderType;

}
