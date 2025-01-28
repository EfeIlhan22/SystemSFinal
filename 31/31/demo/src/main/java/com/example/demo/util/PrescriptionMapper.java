package com.example.demo.util;

import com.example.demo.models.Prescription;
import com.example.demo.models.PrescriptionDTO;

import java.util.stream.Collectors;

public class PrescriptionMapper {

    public static PrescriptionDTO toDTO(Prescription prescription) {
        PrescriptionDTO dto = new PrescriptionDTO();
        dto.setId(prescription.getId());
        dto.setDoctorId(prescription.getDoctor().getId());
        dto.setPatientId(prescription.getPatient().getId());
        dto.setMedicineIds(
                prescription.getMedicines()
                        .stream()
                        .map(medicine -> medicine.getId())
                        .collect(Collectors.toList())
        );
        dto.setIssuedDate(prescription.getIssuedDate());
        return dto;
    }

    public static Prescription toEntity(PrescriptionDTO dto) {
        // Dönüşüm işlemi (eğer gerekirse yapılabilir)
        return null; // Örnek olarak bırakıldı
    }
}
