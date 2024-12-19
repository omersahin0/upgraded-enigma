package com.example.bidfood.business.concretes;

import com.example.bidfood.business.abstracts.AuthService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class AutoManager implements AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AutoManager.class);
    private final RestTemplate restTemplate;

    @Override
    public String authenticateUser(String username, String password) {
        String url = "https://integration.geovisiongroup.com/authorize";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        String requestBody = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        logger.info("API Yanıtı: {}", response.getBody());

        if (response.getStatusCode().is2xxSuccessful()) {
            return extractTokenFromResponse(response.getBody());
        } else {
            logger.error("Token alma işlemi başarısız. Yanıt Kodu: {}", response.getStatusCode());
            throw new RuntimeException("Failed to retrieve JWT token: " + response.getStatusCode());
        }
    }

    @Override
    public String extractTokenFromResponse(String responseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            JsonNode dataNode = jsonNode.path("data");
            if (dataNode.isMissingNode()) {
                throw new RuntimeException("Data node missing in response");
            }
            return dataNode.path("access_token").asText();
        } catch (Exception e) {
            logger.error("JWT token çıkartma hatası: {}", e.getMessage());
            throw new RuntimeException("Failed to parse JWT token from response", e);
        }
    }
}
