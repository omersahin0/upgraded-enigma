package com.example.order_management.business.abstracts;

import com.example.order_management.business.request.OutletCreateRequest;
import com.example.order_management.business.responses.OutletResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OutletService {
    List<OutletResponse> getAllOutlets();
     OutletResponse getOutletById(String id);
     void createOutlet(OutletCreateRequest outletCreateRequest);
     void deleteOutlet(int id);
}
