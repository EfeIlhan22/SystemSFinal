package com.example.demo.service;

import com.example.demo.models.MedicineItem;
import com.example.demo.models.Prescription;
import com.example.demo.repository.PrescriptionRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PrescriptionService {
    final PrescriptionRepository prescriptionRepository;
    public Prescription getPrescription(int id) {
        return prescriptionRepository.findById(id);
    }
    private MedicineItem getMedicineFromMongo(String medicineId, String medicineName, int quantity) {
        try {
            MedicineItem medicine = webClient.get()
                    .uri("/api/medicines/v1/{id}", medicineId)
                    .retrieve()
                    .bodyToMono(MedicineItem.class)
                    .block();

            if (medicine == null) {
                throw new RuntimeException("Medicine not found with ID: " + medicineId);
            }

            medicine.setMedicineId(medicineId);
            medicine.setQuantity(quantity);
            medicine.setMedicineName(medicineName);
            return medicine;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching medicine details: " + e.getMessage());
        }
    }
    String validationUrl = "https://run.mocky.io/v3/92a14287-608d-47c4-b544-22be2f9c7dc4";
    private  WebClient webClient;
    @PostConstruct
    public void init() {
        this.webClient = WebClient.builder()
                .baseUrl(validationUrl)
                .build();
    }
    private void validateTC(String tcNumber) {
        try {
            // Fetch response from TC validation service
            Map<String, Object> response = webClient.get()
                    .uri(validationUrl + "?tc={tc}", tcNumber)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                    .block(Duration.ofSeconds(5));

            // Log the response for debugging
            System.out.println("Validation Response: " + response);

            // Ensure response is not null and contains the expected key
            if (response == null || !response.containsKey("isValid")) {
                throw new RuntimeException("Validation service returned an invalid response");
            }

            // Parse and return the validation result
            response.get("isValid");
        } catch (Exception e) {
            throw new RuntimeException("Error during TC validation: " + e.getMessage());
        }
    }

}
