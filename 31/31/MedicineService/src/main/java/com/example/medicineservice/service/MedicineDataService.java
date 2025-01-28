package com.example.medicineservice.service;

import com.example.medicineservice.model.Medicine;
import com.example.medicineservice.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineDataService {
    private final MedicineRepository medicineRepository;

    @Autowired
    public MedicineDataService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public void saveMedicines(List<Medicine> medicines) {
        medicineRepository.saveAll(medicines);
    }
}

