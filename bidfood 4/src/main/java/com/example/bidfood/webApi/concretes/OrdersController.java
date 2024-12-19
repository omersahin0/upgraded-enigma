package com.example.bidfood.webApi.concretes;

import com.example.bidfood.business.concretes.OrderManager;
import com.example.bidfood.business.responses.CreateOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrdersController {

    @Autowired
    private OrderManager orderManager;

    @GetMapping("/order/{orderCode}")
    public CreateOrderResponse getOrderByOrderCode(@PathVariable String orderCode) {
        return orderManager.getOrderByOrderCode(orderCode);
    }
}
