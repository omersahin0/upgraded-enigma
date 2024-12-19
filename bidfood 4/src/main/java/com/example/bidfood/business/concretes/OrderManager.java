package com.example.bidfood.business.concretes;

import com.example.bidfood.business.responses.CreateOrderResponse;
import com.example.bidfood.business.responses.CreateProductResponse;
import com.example.bidfood.dataAccess.abstracts.OrderRepository;
import com.example.bidfood.dataAccess.abstracts.ProductRepository;
import com.example.bidfood.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bidfood.entities.concretes.Order;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderManager {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public CreateOrderResponse getOrderByOrderCode(String orderCode) {
        // Tek bir sipariş döndürüyoruz
        Order order = orderRepository.findByOrderCode(orderCode);

        // Sipariş bulunamazsa hata fırlatabiliriz
        if (order == null) {
            throw new IllegalArgumentException("Order not found for orderCode: " + orderCode);
        }

        // CreateOrderResponse nesnesini oluşturuyoruz
        CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        createOrderResponse.setOrderCode(order.getOrderCode());
        createOrderResponse.setCargoWeight(order.getCargoWeight());
        createOrderResponse.setCargoDepth(order.getCargoDepth());
        createOrderResponse.setCargoHeight(order.getCargoHeight());
        createOrderResponse.setCargoWidth(order.getCargoWidth());

        // Ürünleri almak için
        List<CreateProductResponse> productList = new ArrayList<>();
        // Siparişin ürünlerini almak için
        Product product = productRepository.findById(order.getProductUid().getUid()).orElseThrow();
        CreateProductResponse createProductResponse = new CreateProductResponse();
        createProductResponse.setProductName(product.getProductName());
        createProductResponse.setProductCode(product.getProductCode());
        productList.add(createProductResponse);

        createOrderResponse.setProducts(productList);

        return createOrderResponse;
    }
}

