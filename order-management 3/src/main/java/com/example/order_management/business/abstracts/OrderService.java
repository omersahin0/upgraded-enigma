package com.example.order_management.business.abstracts;


import com.example.order_management.business.request.OrderCreateRequest;
import com.example.order_management.business.responses.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getAllOrders();
    OrderResponse getOrderById(String id);
    List<OrderResponse> getOrdersByOutlet(String outletCode);
    void createOrder(OrderCreateRequest createOrderRequest);
    void deleteOrder(String id);
    void acceptOrder(String id);
    void rejectOrder(String id);


}
