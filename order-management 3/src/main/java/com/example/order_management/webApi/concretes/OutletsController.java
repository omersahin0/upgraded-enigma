package com.example.order_management.webApi.concretes;

import com.example.order_management.business.abstracts.OutletService;
import com.example.order_management.business.request.OutletCreateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OutletsController {

    private OutletService outletService;

    @PostMapping("/outlet")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createOutlet(@RequestBody OutletCreateRequest createOutletRequest) {
        outletService.createOutlet(createOutletRequest);
    }
    @DeleteMapping("/outlet")
    public void deleteOutlet(@PathVariable int id) {
        outletService.deleteOutlet(id);
    }


}
