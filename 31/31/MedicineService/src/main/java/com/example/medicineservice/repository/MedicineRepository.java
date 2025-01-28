package com.example.medicineservice.repository;

import com.example.medicineservice.model.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends MongoRepository<Medicine, String> {
    List<Medicine> findByNameContainingIgnoreCase(String query);
}
