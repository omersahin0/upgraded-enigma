package com.example.bidfood.business.concretes;

import com.example.bidfood.business.responses.CreateOutletResponse;
import com.example.bidfood.dataAccess.abstracts.OutletRepository;
import com.example.bidfood.entities.concretes.Outlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutletManager {

    @Autowired
    private OutletRepository outletRepository;

    public CreateOutletResponse getOutletByOutletCode(String outletCode) {

        Outlet outlet = outletRepository.findByOutletCode(outletCode);
        CreateOutletResponse createOutletResponse = new CreateOutletResponse();
        createOutletResponse.setOutletCode(outlet.getOutletCode());
        createOutletResponse.setSignName(outlet.getSignName());
        createOutletResponse.setLegalName(outlet.getLegalName());
        createOutletResponse.setGsmNumber(outlet.getGsmNumber());

        return createOutletResponse;
    }

}
