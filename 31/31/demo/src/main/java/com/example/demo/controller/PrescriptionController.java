package com.example.demo.controller;

import com.example.demo.models.Prescription;
import com.example.demo.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prescription/v1")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    @RequestMapping("/prescription")
    public ResponseEntity<Prescription> prescription(@RequestParam int id) {
        try {
            Prescription prescription = prescriptionService.getPrescription(id);
            return ResponseEntity.ok(prescription);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
