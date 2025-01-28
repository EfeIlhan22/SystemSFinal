package com.example.demo.controller;

import com.example.demo.models.Prescription;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pharmacy/v1")
public class PharmacyController{
    private final PharmacyService pharmacyService;

    @PostMapping("/update")
    public ResponseEntity<?> updatePrescription(@RequestBody Prescription prescription) {
        String status = pharmacyService.submitPrescription(prescription);
        if ("successful".equals(status)) {
            return ResponseEntity.ok().body("{\"status\": \"successful\"}");
        } else {
            return ResponseEntity.badRequest().body("{\"status\": \"error\", \"message\": \"" + status + "\"}");
        }
    }
}