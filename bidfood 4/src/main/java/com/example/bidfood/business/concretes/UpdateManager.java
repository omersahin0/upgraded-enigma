package com.example.bidfood.business.concretes;

import com.example.bidfood.business.responses.CreateOrderResponse;
import com.example.bidfood.business.responses.CreateOutletResponse;
import com.example.bidfood.business.responses.CreateProductResponse;
import com.example.bidfood.dataAccess.abstracts.OrderRepository;
import com.example.bidfood.dataAccess.abstracts.OutletRepository;
import com.example.bidfood.dataAccess.abstracts.ProductRepository;
import com.example.bidfood.entities.concretes.Order;
import com.example.bidfood.entities.concretes.Outlet;
import com.example.bidfood.entities.concretes.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UpdateManager {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OutletRepository outletRepository;

    // API'den veri çeker
    public String getdata() {
        String url = "https://integration.geovisiongroup.com/api/dispatch-outlet?startDate=2024-01-01&endDate=2024-01-02&warehouseCode=BANA-ANA DEPO&includeProducts=true";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer 57fa17cd8656478eaf65dbed801a77ef");
        headers.add("Content-Type", "application/json");

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String responseBody = response.getBody();
        System.out.println("Fetched Data: " + responseBody);
        return responseBody;
    }

    @Transactional
    public ResponseEntity<String> saveData() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String fetchData = getdata();

        if (fetchData == null || fetchData.isEmpty()) {
            return new ResponseEntity<>("Failed to fetch the data", HttpStatus.EXPECTATION_FAILED);
        }

        JsonNode rootNode = mapper.readTree(fetchData);
        JsonNode dataNode = rootNode.get("data");

        if (dataNode == null) {
            return new ResponseEntity<>("Failed to fetch the data", HttpStatus.EXPECTATION_FAILED);
        }

        // Veriyi işleyip kaydetme
        for (JsonNode orderNode : dataNode) {
            CreateOutletResponse createOutletResponse = mapper.treeToValue(orderNode, CreateOutletResponse.class);
            CreateOrderResponse createOrderResponse = mapper.treeToValue(orderNode, CreateOrderResponse.class);

            // Outlet verisi
            Outlet outlet = new Outlet();
            if (outletRepository.findByOutletCode(createOutletResponse.getOutletCode()) == null) {
                outlet.setOutletCode(createOutletResponse.getOutletCode());
                outlet.setSignName(createOutletResponse.getSignName());
                outlet.setLegalName(createOutletResponse.getLegalName());
                outlet.setGsmNumber(createOutletResponse.getGsmNumber());
                outlet.setEmail(createOutletResponse.getEmail());
                outlet.setAddress(createOutletResponse.getAddress());
                outlet.setCountry(createOutletResponse.getCountry());
                outlet.setCity(createOutletResponse.getCity());
                outlet.setPostCode(createOutletResponse.getPostCode());
                outlet.setLatitude(createOutletResponse.getLatitude());
                outlet.setLongitude(createOutletResponse.getLongitude());
                outlet.setTwStart(createOutletResponse.getTwStart());
                outlet.setTwFinish(createOutletResponse.getTwFinish());
                outlet.setServiceTime(createOutletResponse.getServiceTime());
                outletRepository.save(outlet);
                System.out.println("Outlet saved: " + outlet.getOutletCode()); // Loglama
            }

            // Ürün verisi
            JsonNode products = orderNode.get("products");
            for (JsonNode productNode : products) {
                CreateProductResponse createProductResponse = mapper.treeToValue(productNode, CreateProductResponse.class);

                Product product = new Product();
                if (productRepository.findByProductCode(createProductResponse.getProductCode()) == null) {
                    product.setProductCode(createProductResponse.getProductCode());
                    product.setProductName(createProductResponse.getProductName());
                    product.setQuantity(createProductResponse.getQuantity());
                    product.setSize1(createProductResponse.getSize1());
                    product.setSize2(createProductResponse.getSize2());
                    product.setSize3(createProductResponse.getSize3());
                    product.setSize4(createProductResponse.getSize4());
                    product.setQuantityUnit(createProductResponse.getQuantityUnit());
                    product.setOrderType(createProductResponse.getOrderType());
                    productRepository.save(product);
                    System.out.println("Product saved: " + product.getProductCode()); // Loglama
                }

                // Sipariş verisi
                Order order = new Order();

                if (orderRepository.findByOrderCode(createOrderResponse.getOrderCode()) == null) {
                    // Outlet ve Product nesnelerini veritabanından alıyoruz
                    Outlet ooutlet = outletRepository.findById(createOrderResponse.getOutletUid())
                            .orElseThrow(() -> new RuntimeException("Outlet bulunamadı"));
                    Product pproduct = productRepository.findById(createOrderResponse.getProductUid())
                            .orElseThrow(() -> new RuntimeException("Product bulunamadı"));

                    // Order nesnesine değerleri atıyoruz
                    order.setOrderCode(createOrderResponse.getOrderCode());
                    order.setProductUid(pproduct); // Product nesnesi
                    order.setOutletUid(ooutlet);   // Outlet nesnesi
                    order.setCargoWidth(createOrderResponse.getCargoWidth());
                    order.setCargoDepth(createOrderResponse.getCargoDepth());
                    order.setCargoWeight(createOrderResponse.getCargoWeight());
                    order.setCargoHeight(createOrderResponse.getCargoHeight());
                    order.setDeliveryDate(createOrderResponse.getDeliveryDate());
                    order.setOrderDate(createOrderResponse.getOrderDate());

                    // Order'ı veritabanına kaydediyoruz
                    orderRepository.save(order);
                    System.out.println("Order saved: " + order.getOrderCode()); // Loglama
                }

            }
        }

        System.out.println("Veriler başarıyla kaydedildi");
        return new ResponseEntity<>("Data added to the database successfully", HttpStatus.OK);
    }
}
