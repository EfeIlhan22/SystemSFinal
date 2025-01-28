package com.example.demo.service;

import com.example.demo.models.Prescription;
import com.example.demo.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrescriptionService {
    final PrescriptionRepository prescriptionRepository;
    public Prescription getPrescription(int id) {
        return prescriptionRepository.findById(id);
    }
}
