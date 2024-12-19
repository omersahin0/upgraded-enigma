package com.example.bidfood.entities.concretes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "outlets")
public class Outlet {

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uid;

    @Column(name = "outlet_code")
    private String outletCode;

    @Column(name = "sign_name")
    private String signName;

    @Column(name = "legal_name")
    private String legalName;

    @Column(name = "gsm_number")
    private String gsmNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "tw_start")
    private String twStart;

    @Column(name = "tw_finish")
    private String twFinish;

    @Column(name = "service_time")
    private String serviceTime;

}

