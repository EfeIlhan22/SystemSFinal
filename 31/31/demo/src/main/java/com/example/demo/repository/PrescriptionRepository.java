package com.example.demo.repository;

import com.example.demo.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    Prescription findById(int prescriptionId);
}
