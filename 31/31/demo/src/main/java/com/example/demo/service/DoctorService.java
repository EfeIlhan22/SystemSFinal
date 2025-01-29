package com.example.demo.service;

import com.example.demo.models.Prescription;
import com.example.demo.models.PrescriptionDTO;
import com.example.demo.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {
    final PrescriptionRepository prescriptionRepository;
    private final ModelMapper modelMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public String addPrescription(Prescription prescription) {
        try {
            prescriptionRepository.save(prescription);
            PrescriptionDTO dto = modelMapper.map(prescription, PrescriptionDTO.class);
            rabbitTemplate.convertAndSend("prescriptionQueue", dto);
            return "successful";
        } catch (Exception e) {
            return "error: " + e.getMessage();
        }
    }

}
