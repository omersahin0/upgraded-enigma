package com.example.order_management.business.concretes;

import com.example.order_management.business.abstracts.OrderService;
import com.example.order_management.business.request.OrderCreateRequest;
import com.example.order_management.business.responses.OrderResponse;
import com.example.order_management.core.utulities.mappers.ModelMapperService;
import com.example.order_management.dataAccess.abstracts.OrderRepository;
import com.example.order_management.entities.concretes.Order;
import com.example.order_management.entities.concretes.Status;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public  class OrderManager implements OrderService {

    private final OrderRepository repository;
    private final ModelMapperService modelMapperService;

    public OrderManager(OrderRepository repository, ModelMapperService modelMapperService) {
        this.repository = repository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<OrderResponse> getAllOrders() {

        List<Order> orders = repository.findAll();


        return orders.stream().map(order -> modelMapperService.forResponse().map(order, OrderResponse.class))
                .toList();
    }

    @Override
    public OrderResponse getOrderById(String id) {
        Order order = repository.findById(id).orElseThrow(()-> new RuntimeException("Order not found with id : " + id));
        return modelMapperService.forResponse().map(order, OrderResponse.class);

    }

    @Override
    public List<OrderResponse> getOrdersByOutlet(String outletCode) {
            List<Order> orders = repository.findByOutletCode(outletCode);
            return orders.stream()
                    .map(order -> modelMapperService.forResponse().map(order, OrderResponse.class))
                    .toList();
        }


    @Override
    public void createOrder(OrderCreateRequest createOrderRequest) {

        Order order = modelMapperService.forRequest().map(createOrderRequest, Order.class);
        repository.save(order);

    }

    @Override
    public void deleteOrder(String id) {
        repository.deleteById(id);
    }

    @Override
    public void acceptOrder(String id) {
        Order order = repository.findById(id).orElseThrow(()-> new RuntimeException("Order not found with id : "));
        order.setStatus(Status.valueOf("ACCEPTED"));
        repository.save(order);
    }

    @Override
    public void rejectOrder(String id) {
        Order order = repository.findById(id).orElseThrow(()-> new RuntimeException("Order not found with id : "));
        order.setStatus(Status.valueOf("REJECTED"));
        repository.save(order);

    }
}
