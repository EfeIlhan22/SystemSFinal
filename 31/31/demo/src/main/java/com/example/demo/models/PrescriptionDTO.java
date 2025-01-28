package com.example.demo.models;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class PrescriptionDTO implements Serializable {
    private Long id;
    private Long doctorId;        // Doktorun ID'si (ManyToOne bağımlılığı kaldırıldı)
    private Long patientId;       // Hastanın ID'si (ManyToOne bağımlılığı kaldırıldı)
    private List<Long> medicineIds; // İlaçların ID listesi
    private LocalDate issuedDate;
}

