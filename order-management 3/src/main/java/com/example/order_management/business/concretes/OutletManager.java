package com.example.order_management.business.concretes;

import com.example.order_management.business.abstracts.OutletService;
import com.example.order_management.business.request.OutletCreateRequest;
import com.example.order_management.business.responses.OutletResponse;
import com.example.order_management.core.utulities.mappers.ModelMapperService;
import com.example.order_management.dataAccess.abstracts.OutletRepository;
import com.example.order_management.entities.concretes.Outlet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutletManager implements OutletService {

    private OutletRepository outletRepository;
    private ModelMapperService modelMapperService;
    public OutletManager(OutletRepository outletRepository, ModelMapperService modelMapperService) {
        this.outletRepository = outletRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<OutletResponse> getAllOutlets() {
        List<Outlet> outlets = outletRepository.findAll();
        return outlets.stream()
                .map(outlet -> modelMapperService.forResponse()
                        .map(outlet, OutletResponse.class)).toList();

    }


    public OutletResponse getOutletById(String id) {
        Outlet outlet = outletRepository.findById("id")
                .orElseThrow(() -> new RuntimeException("Outlet not found with id: " + id));
        return modelMapperService.forResponse().map(outlet, OutletResponse.class);
    }

    @Override
    public void createOutlet(OutletCreateRequest outletCreateRequest) {
        Outlet outlet = modelMapperService.forRequest().map(outletCreateRequest, Outlet.class);
        outletRepository.save(outlet);

    }

    @Override
    public void deleteOutlet(int id) {
        outletRepository.deleteById("id");

    }
}
