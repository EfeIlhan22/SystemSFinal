package com.example.demo.service;

import com.example.demo.models.Prescription;
import com.example.demo.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PharmacyService {
    final PrescriptionRepository prescriptionRepository;
    public String submitPrescription(Prescription prescription) {
        try {
            prescriptionRepository.save(prescription);
            return "successful";
        } catch (Exception e) {
            return "error: " + e.getMessage();
        }
    }
}
