package com.example.order_management.dataAccess.abstracts;

import com.example.order_management.entities.concretes.Outlet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OutletRepository extends MongoRepository<Outlet,String> {

}
