package com.example.bidfood.business.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOrderResponse {

    @JsonProperty("order_code")
    private String orderCode;
    @JsonProperty("outlet_uid")
    private UUID outletUid;
    @JsonProperty("product_uid")
    private UUID productUid;
    @JsonProperty("cargo_width")
    private int cargoWidth;
    @JsonProperty("cargo_depth")
    private int cargoDepth;
    @JsonProperty("cargo_height")
    private int cargoHeight;
    @JsonProperty("cargo_weight")
    private int cargoWeight;
    @JsonProperty("delivery_date")
    private String deliveryDate;
    @JsonProperty("order_date")
    private String orderDate;
    private List<CreateProductResponse> products;

}