package com.example.bidfood.webApi.concretes;

import com.example.bidfood.business.concretes.UpdateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UpdatesController {

    @Autowired
    private UpdateManager updateManager;

    @PostMapping("/update")
    public ResponseEntity<String> updateData() {
        try {
            return updateManager.saveData();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error occurred while updating data: " + e.getMessage());
        }
    }
}

