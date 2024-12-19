package com.example.bidfood.business.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOutletResponse {

    @JsonProperty("outlet_code")
    private String outletCode;
    @JsonProperty("sign_name")
    private String signName;
    @JsonProperty("legal_name")
    private String legalName;
    @JsonProperty("gsm_number")
    private String gsmNumber;
    private String email;
    private String address;
    private String country;
    private String city;
    @JsonProperty("post_code")
    private String postCode;
    private double latitude;
    private double longitude;
    @JsonProperty("tw_start")
    private String twStart;
    @JsonProperty("tw_finish")
    private String twFinish;
    @JsonProperty("service_time")
    private String serviceTime;

}
