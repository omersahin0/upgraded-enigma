package com.example.bidfood.business.abstracts;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String authenticateUser(String userName , String password) ;
    String extractTokenFromResponse(String responseBody);
}
