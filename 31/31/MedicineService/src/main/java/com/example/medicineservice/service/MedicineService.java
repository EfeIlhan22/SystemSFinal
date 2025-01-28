package com.example.medicineservice.service;

import com.example.medicineservice.model.Medicine;
import com.example.medicineservice.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class MedicineService {
    private final MedicineRepository medicineRepository;
    private final RedisTemplate<String, List<String>> redisTemplate;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository, RedisTemplate<String, List<String>> redisTemplate) {
        this.medicineRepository = medicineRepository;
        this.redisTemplate = redisTemplate;
    }

    public List<String> searchMedicines(String query) {
        String cacheKey = "medicines:" + query.toLowerCase();

        // Redis'ten kontrol et
        List<String> cachedMedicines = redisTemplate.opsForValue().get(cacheKey);
        if (cachedMedicines != null) {
            return cachedMedicines;
        }

        // MongoDB'den arama yap
        List<Medicine> medicines = medicineRepository.findByNameContainingIgnoreCase(query);
        List<String> medicineNames = medicines.stream()
                .map(Medicine::getName)
                .toList();

        // Sonuçları Redis'e kaydet
        redisTemplate.opsForValue().set(cacheKey, medicineNames, Duration.ofHours(1));

        return medicineNames;
    }
}

