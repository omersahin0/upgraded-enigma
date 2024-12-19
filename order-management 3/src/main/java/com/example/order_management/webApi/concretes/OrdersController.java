package com.example.order_management.webApi.concretes;

import com.example.order_management.business.abstracts.OrderService;
import com.example.order_management.business.abstracts.OutletService;
import com.example.order_management.business.request.OrderCreateRequest;
import com.example.order_management.business.responses.OrderResponse;
import com.example.order_management.business.responses.OutletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrdersController {

    private final OutletService outletService;
    private OrderService orderService;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderCreateRequest createOrderRequest) {

        orderService.createOrder(createOrderRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        this.orderService.deleteOrder("id");
    }

    @GetMapping("/order_code")
    public List<OrderResponse> getOrdersById(@RequestParam String orderCode) {
        return List.of(orderService.getOrderById(orderCode));
    }
    @GetMapping("/outlet_code")
    public List<OrderResponse> getOrdersByOutletCode(@RequestParam String outletCode) {
        return orderService.getOrdersByOutlet(outletCode);
    }


        @PutMapping("/order/accept")
        public void acceptOrder (@PathVariable String id){
            this.orderService.acceptOrder("id");
        }
        @PutMapping("/order/reject")
        public void rejectOrder (@PathVariable String id){
            this.orderService.rejectOrder("id");
        }

    }

