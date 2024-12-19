package com.example.bidfood.dataAccess.abstracts;

import com.example.bidfood.entities.concretes.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OutletRepository extends JpaRepository<Outlet, UUID> {
    Outlet findByOutletCode(String outletCode);
}
